package com.main.magazine.mapping;

import com.main.magazine.model.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CommentMapping {

    private Long id;
    private String title;
    private String message;
    private Article article_id;
}
