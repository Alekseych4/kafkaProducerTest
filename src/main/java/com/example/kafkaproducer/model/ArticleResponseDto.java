package com.example.kafkaproducer.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleResponseDto {
    private String writerNickname;
    private String articleTitle;
    private int charactersWithSpaces;
    private int words;
    private int spaces;
    private String article;
}
