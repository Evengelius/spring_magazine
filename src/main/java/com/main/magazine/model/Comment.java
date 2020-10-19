package com.main.magazine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@Getter @Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "This field cannot be empty : please provide a title")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "This field cannot be empty : please provide a message")
    @Column(nullable = false, columnDefinition = "text")
    private String message;

    @Column()
    private Instant created_at;

    // ******************************* Relationship ******************************* //

    /**
     * <strong>Article | Comment</strong> <br />
     * ManyToOne | Many comments belong to One article
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    @JsonIgnore
    private Article article;
}
