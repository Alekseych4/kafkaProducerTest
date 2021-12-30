package com.example.kafkaproducer.controller;

import com.example.kafkaproducer.model.ArticleDto;
import com.example.kafkaproducer.model.ArticleResponseDto;
import com.example.kafkaproducer.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/create")
    public void createArticle(@RequestBody ArticleDto articleDto){
        articleService.createArticle(articleDto);
    }

    @GetMapping("/{title}/{nickname}")
    public ArticleResponseDto getArticleByTitleAndAuthorNickname(@PathVariable("title") String title,
                                                                 @PathVariable("nickname") String nickname) {
        return articleService.getArticleByTitleAndAuthorNickname(title, nickname);
    }

    @DeleteMapping("/{title}/{nickname}")
    public void deleteArticle(@PathVariable("title") String title,
                              @PathVariable("nickname") String nickname) {
        articleService.deleteArticle(title, nickname);
    }
}
