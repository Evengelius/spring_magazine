package com.main.magazine.controllers;

import com.main.magazine.errors.NotFoundException;
import com.main.magazine.mapper.CommentMapper;
import com.main.magazine.mapping.CommentMapping;
import com.main.magazine.model.Comment;
import com.main.magazine.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentMapper commentMapper;
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentMapper commentMapper, CommentService commentService) {
        this.commentMapper = commentMapper;
        this.commentService = commentService;
    }


    // ******************************* GET ******************************* //

    // Comment | Find All
    @GetMapping("/comments")
    public List<CommentMapping> findAll() throws NotFoundException {
        return this.commentMapper.entityListToDto(commentService.findAll());
    }

    // ****************************** POST ****************************** //

    // Comment | Store
    @PostMapping("/articles/{articleId}/comments")
    /*
     * @Valid tells Spring Boot to automatically instantiate a Validator, and to validate the object : Comment here.
     * This check is performed before the method body is executed.
     * If the validation fails, the method will throw a MethodArgumentNotValidException,
     * which is mapped to the 400 Bad Request response status by default
     */
    public ResponseEntity<Void> create(@PathVariable Long articleId, @Valid @RequestBody Comment comment) throws NotFoundException {
        this.commentService.store(articleId, comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
