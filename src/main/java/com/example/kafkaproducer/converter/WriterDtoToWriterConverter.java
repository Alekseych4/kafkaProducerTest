package com.example.kafkaproducer.converter;

import com.example.kafkaproducer.model.WriterDto;
import com.example.schemas.WriterSchema;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WriterDtoToWriterConverter implements Converter<WriterDto, WriterSchema> {
    @Override
    public WriterSchema convert(WriterDto source) {
        return WriterSchema.newBuilder()
                .setNickname(source.getNickname())
                .setName(source.getName())
                .setSurname(source.getSurname())
                .setRating(source.getRating())
                .build();
    }
}
