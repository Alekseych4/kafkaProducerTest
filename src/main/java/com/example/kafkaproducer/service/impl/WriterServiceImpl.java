package com.example.kafkaproducer.service.impl;

import com.example.kafkaproducer.exception.DefaultResponseException;
import com.example.kafkaproducer.exception.ProducerException;
import com.example.kafkaproducer.model.WriterDto;
import com.example.kafkaproducer.model.WriterResponseDto;
import com.example.schemas.WriterResponseSchema;
import com.example.schemas.WriterSchema;
import com.example.kafkaproducer.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@KafkaListener(
        groupId = "writerResponseProcessor",
        topics = {"writer_response_topic"},
        containerFactory = "writerListenerContainerFactory")
public class WriterServiceImpl implements WriterService {
    @Value("${topic.writer-topic}")
    private String generatorTopic;
    private static final String redisKey = "_response";
    private final Logger logger = LoggerFactory.getLogger(WriterServiceImpl.class);

    private final RedisTemplate<String, Object> redisTemplate;
    private final ConversionService conversionService;
    private final KafkaTemplate<String, WriterSchema> kafkaTemplate;

    @Override
    public WriterResponseDto getWriterByNickname(String nickname) {
        var writerResponse = getPersistedResponse(nickname)
                .orElseThrow(() -> new DefaultResponseException("No such key!"));
        var writerResponseDto = conversionService.convert(writerResponse, WriterResponseDto.class);
        return writerResponseDto;
    }

    @Override
    public void createWriter(WriterDto writerDto) {
        var convertedWriter = conversionService.convert(writerDto, WriterSchema.class);
        try {
            var res = kafkaTemplate.send(generatorTopic, convertedWriter).get();
            logger.info("----------------SEND MSG--------------------");
            logger.info("topic: " + res.getRecordMetadata().topic());
            logger.info("partition: " + res.getRecordMetadata().partition());
            logger.info("data: " + res.getProducerRecord().toString());
            logger.info("offset: " + res.getRecordMetadata().offset());
        } catch (ExecutionException | InterruptedException e) {
            logger.error("ERROR while sending msg to Kafka: ", e);
            throw new ProducerException("Writer producer couldn't send schema with cause: \n" + e.getMessage());
        }
        logger.info("---------------------------------------------");
    }

    @Override
    public void deleteWriter(String nickname) {
        String key = getRedisKey(nickname);
        if (Boolean.FALSE.equals(redisTemplate.delete(key)))
            throw new DefaultResponseException("No such key to delete!");
    }

    @KafkaHandler
    public void consumeWriterResult(WriterResponseSchema record) {
        logger.info("--------------------------Writer KafkaHandler----------------------------");
        logger.info("@KafkaHandler record.toString: " + record.toString());
        logger.info("group.id: " + KafkaUtils.getConsumerGroupId());
        logger.info("------------------------------------------------------------------------");
        saveResponse(record);
    }

    private void saveResponse(WriterResponseSchema writerResponseSchema) {
        String responseKey = getRedisKey(writerResponseSchema.getNickname().toString());
        logger.info("Save to redis: " + responseKey + " " + writerResponseSchema);
        redisTemplate.opsForValue().set(responseKey, writerResponseSchema);
    }

    private Optional<WriterResponseSchema> getPersistedResponse(String writerNickname) {
        String key = getRedisKey(writerNickname);
        var writerResponse = redisTemplate.opsForValue().get(key);
        if (writerResponse instanceof WriterResponseSchema) {
            return Optional.of((WriterResponseSchema) writerResponse);
        }
        return Optional.empty();
    }

    private String getRedisKey(String nickname) {
        return nickname + redisKey;
    }
}
