package com.example.kafkaproducer.converter;

import com.example.kafkaproducer.model.ArticleDto;
import com.example.schemas.ArticleSchema;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArticleDtoToArticleSchemaConverter implements Converter<ArticleDto, ArticleSchema> {
    @Override
    public ArticleSchema convert(ArticleDto source) {
        return ArticleSchema.newBuilder()
                .setUniqueArticleName(source.getArticleTitle() + "_" + source.getWriterNickname())
                .setWriterNickname(source.getWriterNickname())
                .setArticleTitle(source.getArticleTitle())
                .setText(source.getText())
                .build();
    }
}
