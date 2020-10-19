package com.main.magazine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "images")
@NoArgsConstructor
@Getter @Setter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "This field cannot be empty : please provide a name")
    @Column(nullable = false)
    private String name;

    // ******************************* Relationship ******************************* //

    /**
     * <strong>Article | Image</strong> <br />
     * ManyToOne | Many images belong to One article
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    @JsonIgnore
    private Article article;
}
