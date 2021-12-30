package com.example.kafkaproducer.service;

import com.example.kafkaproducer.model.ArticleDto;
import com.example.kafkaproducer.model.ArticleResponseDto;

public interface ArticleService {
    ArticleResponseDto getArticleByTitleAndAuthorNickname(String title, String nickname);
    void createArticle(ArticleDto articleDto);
    void deleteArticle(String title, String nickname);
}
