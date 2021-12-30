package com.example.kafkaproducer.converter;

import com.example.kafkaproducer.model.WriterResponseDto;
import com.example.schemas.WriterResponseSchema;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WriterResponseSchemaToWriterResponseDtoConverter implements Converter<WriterResponseSchema, WriterResponseDto> {
    @Override
    public WriterResponseDto convert(WriterResponseSchema source) {
        return WriterResponseDto.builder()
                .nickname(source.getNickname().toString())
                .greet(source.getGreetMessage().toString())
                .name(source.getWriter().getName().toString())
                .surname(source.getWriter().getSurname().toString())
                .rating(source.getWriter().getRating())
                .build();
    }
}
