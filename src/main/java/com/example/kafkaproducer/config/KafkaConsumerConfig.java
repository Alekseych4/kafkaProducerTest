package com.example.kafkaproducer.config;

import com.example.schemas.WriterResponseSchema;
import com.example.schemas.ArticleResponseSchema;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${topic.schema.registry.url}")
    private String schemaRegistryUrl;

    @Bean
    public ConsumerFactory<String, WriterResponseSchema> writerConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(configProperties("writerResponseProcessor"));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, WriterResponseSchema> writerListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, WriterResponseSchema> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(writerConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, ArticleResponseSchema> articleConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(configProperties("articleResponseProcessor"));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ArticleResponseSchema> articleListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ArticleResponseSchema> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(articleConsumerFactory());
        return factory;
    }

    private Map<String, Object> configProperties(String groupId) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        props.put("schema.registry.url", schemaRegistryUrl);

        return props;
    }
}
