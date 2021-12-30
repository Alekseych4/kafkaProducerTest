package com.example.kafkaproducer.config;

import com.example.schemas.WriterSchema;
import com.example.schemas.ArticleSchema;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.*;

@Configuration
public class KafkaProducerConfig {
    @Value("${topic.schema.registry.url}")
    private String schemaRegistryUrl;
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ProducerFactory<?, ?> producerFactory() {

        Map<String, Object> configProps = new HashMap<>();

        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        configProps.put("schema.registry.url", schemaRegistryUrl);

        return new DefaultKafkaProducerFactory<>(configProps);

//        Properties properties = new Properties();
//
//        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:32090");
//        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
//        properties.setProperty("schema.registry.url", "http://127.0.0.1:30999");
//
//        KafkaProducer<String, WriterSchema> kafkaProducer = new KafkaProducer<>(properties);
//
//        return kafkaProducer;
    }

    @Bean
    public KafkaTemplate<String, WriterSchema> writerSchemaKafkaTemplate(ProducerFactory<String, WriterSchema> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public KafkaTemplate<String, ArticleSchema> articleSchemaKafkaTemplate(ProducerFactory<String, ArticleSchema> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
