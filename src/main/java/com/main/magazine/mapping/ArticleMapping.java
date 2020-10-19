package com.main.magazine.mapping;

import com.main.magazine.model.Collection;
import com.main.magazine.model.Comment;
import com.main.magazine.model.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class ArticleMapping {

    private Long id;
    private String title;
    private String description;
    private String author;
    private List<Image> images;
    private List<Comment> comments;
    private Collection collection_id;
}
