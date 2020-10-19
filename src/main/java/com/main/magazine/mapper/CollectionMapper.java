package com.main.magazine.mapper;

import com.main.magazine.mapping.CollectionMapping;
import com.main.magazine.model.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface CollectionMapper {
    CollectionMapper INSTANCE = Mappers.getMapper(CollectionMapper.class);

    /**
     *
     * Entity to Dto
     * (Collection to CollectionMapping)
     */
    @Mappings({
            @Mapping(target="name", source="collection.name"),
            @Mapping(target="articles", source="collection.articles")
    })
    CollectionMapping entityToDto(Collection collection);

    /**
     *
     * EntityList to Dto
     * (List< Collection > to List< CollectionMapping >)
     */
    List<CollectionMapping> entityListToDto(List<Collection> collections);
}
