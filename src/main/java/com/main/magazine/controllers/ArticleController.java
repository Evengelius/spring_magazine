package com.main.magazine.controllers;

import com.main.magazine.errors.NotFoundException;
import com.main.magazine.mapper.ArticleMapper;
import com.main.magazine.mapping.ArticleMapping;
import com.main.magazine.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    private final ArticleMapper articleMapper;
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleMapper articleMapper, ArticleService articleService) {
        this.articleMapper = articleMapper;
        this.articleService = articleService;
    }

    // ******************************* GET ******************************* //

    // Article | Find All
    @GetMapping("/articles")
    public List<ArticleMapping> findAll() throws NotFoundException {
        return this.articleMapper.entityListToDto(articleService.findAll());
    }


    // Article | Find One | By Id
    @GetMapping("/articles/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ArticleMapping findById(@PathVariable @Positive Long id) throws NotFoundException {
        return this.articleMapper.entityToDto(this.articleService.findById(id));

    }
}
