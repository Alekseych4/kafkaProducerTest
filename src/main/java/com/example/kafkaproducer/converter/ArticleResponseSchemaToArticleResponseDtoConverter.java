package com.example.kafkaproducer.converter;

import com.example.kafkaproducer.model.ArticleResponseDto;
import com.example.schemas.ArticleResponseSchema;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArticleResponseSchemaToArticleResponseDtoConverter implements Converter<ArticleResponseSchema, ArticleResponseDto> {
    @Override
    public ArticleResponseDto convert(ArticleResponseSchema source) {
        return ArticleResponseDto.builder()
                .articleTitle(source.getArticle().getArticleTitle().toString())
                .writerNickname(source.getArticle().getWriterNickname().toString())
                .charactersWithSpaces(source.getCharactersWithSpaces())
                .spaces(source.getSpaces())
                .words(source.getWords())
                .article(source.getArticle().getText().toString())
                .build();
    }
}
