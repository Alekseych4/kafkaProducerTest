package com.example.kafkaproducer.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WriterResponseDto {
    private String nickname;
    private String greet;
    private String name;
    private String surname;
    private Double rating;
}
