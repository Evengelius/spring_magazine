package com.main.magazine.repositories;

import com.main.magazine.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findArticleByTitle(String title);
}
