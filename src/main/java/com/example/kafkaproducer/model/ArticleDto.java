package com.example.kafkaproducer.model;

import lombok.Data;

@Data
public class ArticleDto {
    private String writerNickname;
    private String articleTitle;
    private String text;
}
