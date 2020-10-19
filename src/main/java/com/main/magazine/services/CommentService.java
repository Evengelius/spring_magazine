package com.main.magazine.services;

import com.main.magazine.errors.NotFoundException;
import com.main.magazine.model.Article;
import com.main.magazine.model.Comment;
import com.main.magazine.repositories.ArticleRepository;
import com.main.magazine.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    // ******************************* METHODS  ******************************* //

    /* ******** Find | All ********** */
    public List<Comment> findAll() throws NotFoundException {
        List<Comment> comments = this.commentRepository.findAll();
        if (comments.isEmpty()) {
            throw new NotFoundException("Cannot find the stream of comments.");
        } else {
            return comments;
        }
    }

    /* ******** Store ********** */
    public void store(Long articleId, Comment comment) throws NotFoundException {
        Optional<Article> existingArticle = this.articleRepository.findById(articleId);

        // Get the current article from the url.
        existingArticle.map(
                article -> {
                    // Current date time
                    comment.setCreated_at(Instant.now());
                    // Map each comment's article to the article's url.
                    comment.setArticle(article);
                    // Save the data
                    return this.commentRepository.save(comment);
                })
                .orElseThrow(() -> new NotFoundException("Cannot find the requested article."));
    }
}
