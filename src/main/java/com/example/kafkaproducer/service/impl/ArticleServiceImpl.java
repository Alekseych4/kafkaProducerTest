package com.example.kafkaproducer.service.impl;

import com.example.kafkaproducer.exception.DefaultResponseException;
import com.example.kafkaproducer.exception.ProducerException;
import com.example.kafkaproducer.model.ArticleDto;
import com.example.kafkaproducer.model.ArticleResponseDto;
import com.example.schemas.ArticleResponseSchema;
import com.example.schemas.ArticleSchema;
import com.example.schemas.WriterResponseSchema;
import com.example.kafkaproducer.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@KafkaListener(
        groupId = "articleResponseProcessor",
        topics = {"article_response_topic"},
        containerFactory = "articleListenerContainerFactory")
public class ArticleServiceImpl implements ArticleService {
    @Value("${topic.article-topic}")
    private String generatorTopic;
    private static final String redisKey = "_response";
    private final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    private final RedisTemplate<String, Object> redisTemplate;
    private final ConversionService conversionService;
    private final KafkaTemplate<String, ArticleSchema> kafkaTemplate;

    @Override
    public ArticleResponseDto getArticleByTitleAndAuthorNickname(String title, String nickname) {
        var articleResponse = getPersistedResponse(title, nickname)
                .orElseThrow(() -> new DefaultResponseException("No such key!"));
        var articleResponseDto = conversionService.convert(articleResponse, ArticleResponseDto.class);
        return articleResponseDto;
    }

    @Override
    public void createArticle(ArticleDto articleDto) {
        ArticleSchema articleSchema = conversionService.convert(articleDto, ArticleSchema.class);
        try {
            var res = kafkaTemplate.send(generatorTopic, articleSchema).get();
            logger.info("----------------SEND MSG--------------------");
            logger.info("topic: " + res.getRecordMetadata().topic());
            logger.info("partition: " + res.getRecordMetadata().partition());
            logger.info("data: " + res.getProducerRecord().toString());
            logger.info("offset: " + res.getRecordMetadata().offset());
        } catch (ExecutionException | InterruptedException e) {
            logger.error("ERROR while sending msg to KafkaConsumer: ", e);
            throw new ProducerException("Article producer couldn't send schema with cause: \n" + e.getMessage());
        }
        logger.info("---------------------------------------------");
    }

    @Override
    public void deleteArticle(String title, String nickname) {
        String key = getRedisKey(title, nickname);

        if (Boolean.FALSE.equals(redisTemplate.delete(key)))
            throw new DefaultResponseException("No such key to delete!");
    }

    @KafkaHandler
    public void consumeResponseArticle(ArticleResponseSchema record) {
        logger.info("--------------------------Article KafkaHandler---------------------------");
        logger.info("@KafkaHandler record.toString: " + record.toString());
        logger.info("group.id: " + KafkaUtils.getConsumerGroupId());
        logger.info("------------------------------------------------------------------------");
        save(record);
    }

    private void save(ArticleResponseSchema articleResponseSchema) {
        String responseKey = getRedisKey(articleResponseSchema.getArticle().getArticleTitle().toString(),
                articleResponseSchema.getArticle().getWriterNickname().toString());

        logger.info("Save to redis: " + responseKey + " " + articleResponseSchema);
        redisTemplate.opsForValue().set(responseKey, articleResponseSchema);
    }

    private Optional<ArticleResponseSchema> getPersistedResponse(String articleTitle, String writerNickname) {
        String key = getRedisKey(articleTitle, writerNickname);
        var articleResponse = redisTemplate.opsForValue().get(key);
        if (articleResponse instanceof ArticleResponseSchema) {
            return Optional.of((ArticleResponseSchema) articleResponse);
        }
        return Optional.empty();
    }

    private String getRedisKey(String articleTitle, String writerNickname) {
        return articleTitle + writerNickname + redisKey;
    }
}
