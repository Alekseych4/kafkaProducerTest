package com.example.kafkaproducer.model;

import lombok.Data;

@Data
public class WriterDto {
    private String nickname;
    private String name;
    private String surname;
    private double rating;
}
