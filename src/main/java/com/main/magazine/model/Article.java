package com.main.magazine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "articles")
@NoArgsConstructor
@Getter @Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "This field cannot be empty : please provide a title")
    @Column(nullable = false, unique = true)
    private String title;

    @NotBlank(message = "This field cannot be empty : please provide a description")
    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @NotBlank(message = "This field cannot be empty : please provide an author")
    @Column(nullable = false)
    private String author;

    // ******************************* Relationship ******************************* //

    /**
     * <strong>Article | Image</strong> <br />
     * OneToMany | One article can have Many images
     */
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Image> images;

    /**
     * <strong>Article | Comment</strong> <br />
     * OneToMany | One article can have Many comments <br />
     */
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> comments;

    /* ----------------------------------------------------------- */

    /**
     * <strong>Category | Article</strong> <br />
     * ManyToOne | Many articles belong to One category
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "collection_id")
    @JsonIgnore
    private Collection collection;
}
