package com.main.magazine.services;

import com.main.magazine.errors.NotFoundException;
import com.main.magazine.model.Article;
import com.main.magazine.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    /**
     * <strong>Beans</strong><br />
     * A bean is a "spring" object, which is created, managed and destroyed in Spring Container.<br />
     * A object becomes a spring object when it is injected into the Spring Container through the metadata(i.e annotation), which is called inversion of control.<br />
     * -------------------<br />
     * <strong>Spring IOC | Application Context</strong><br />
     * The Spring IOC is the place where Spring Beans are managed, through dependency injection : all Spring beans are inside the Spring IOC<br />
     * Application Context is able of managing beans because it inherits from BeanFactory SuperInterface<br />
     * -------------------<br />
     * <strong>Component : @Service & @Repository</strong><br />
     * Tells the application context (Spring IOC Container) to inject an instance of ArticleRepository here <br />
     * Spring now got the ArticleRepository inside his container <br />
     * And this thanks to @ComponentScan which is used by Spring to search for Beans.
     */
    @Autowired
    public ArticleService(ArticleRepository articleRepository) { this.articleRepository = articleRepository; }


    // ******************************* METHODS ******************************* //

    /* ******** Find | All ********** */
    public List<Article> findAll() throws NotFoundException {
        List<Article> articles = this.articleRepository.findAll();
        if (articles.isEmpty()) {
            throw new NotFoundException("Cannot find the stream of articles.");
        } else {
            return articles;
        }
    }

    /* ******** Find | One | By Id ********** */
    public Article findById(Long id) throws NotFoundException {
        return this.articleRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Cannot find the requested article.")
                );
    }
}
