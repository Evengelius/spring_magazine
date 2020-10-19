package com.main.magazine.mapper;

import com.main.magazine.mapping.CommentMapping;
import com.main.magazine.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    /**
     *
     * Entity to Dto
     * (Comment to CommentMapping)
     */
    @Mappings({
            @Mapping(target="title", source="comment.title"),
            @Mapping(target="message", source="comment.message"),
            @Mapping(target="article_id", source="comment.article"),
    })
    CommentMapping entityToDto(Comment comment);

    /**
     *
     * EntityList to Dto
     * (List< Comment > to List< CommentMapping >)
     */
    List<CommentMapping> entityListToDto(List<Comment> comments);
}
