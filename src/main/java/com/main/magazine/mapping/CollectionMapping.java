package com.main.magazine.mapping;

import com.main.magazine.model.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class CollectionMapping {

    private Long id;
    private String name;
    private List<Article> articles;
}
