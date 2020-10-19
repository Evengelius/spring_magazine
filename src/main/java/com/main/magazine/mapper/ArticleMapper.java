package com.main.magazine.mapper;

import com.main.magazine.mapping.ArticleMapping;
import com.main.magazine.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    /**
     *
     * Entity to Dto
     * (Article to ArticleMapping)
     */
    @Mappings({
            @Mapping(target="title", source="article.title"),
            @Mapping(target="description", source="article.description"),
            @Mapping(target="author", source="article.author"),
            @Mapping(target="images", source="article.images"),
            @Mapping(target="comments", source="article.comments"),
            @Mapping(target="collection_id", source="article.collection"),
    })
    ArticleMapping entityToDto(Article article);

    /**
     *
     * EntityList to Dto
     * (List< Article > to List< ArticleMapping >)
     */
    List<ArticleMapping> entityListToDto(List<Article> articles);
}
