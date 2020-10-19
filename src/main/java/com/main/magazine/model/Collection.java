package com.main.magazine.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "collections")
@NoArgsConstructor
@Getter @Setter
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "This field cannot be empty : please provide a name")
    @Column(nullable = false, unique = true)
    private String name;

    // ******************************* Relationship ******************************* //

    /**
     * <strong>Category | Article</strong> <br />
     * OneToMany | One category can have Many articles <br />
     * cascade = {CascadeType.MERGE, CascadeType.PERSIST} => useful if I want to set to "null",the collection_id in the Article model.
     */
    @OneToMany(mappedBy = "collection", cascade = {CascadeType.ALL})
    private List<Article> articles;
}
