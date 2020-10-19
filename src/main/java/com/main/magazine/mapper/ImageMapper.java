package com.main.magazine.mapper;

import com.main.magazine.mapping.ImageMapping;
import com.main.magazine.model.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ImageMapper {
    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

    /**
     *
     * Entity to Dto
     * (Image to ImageMapping)
     */
    @Mappings({
            @Mapping(target="name", source="image.name"),
    })
    ImageMapping entityToDto(Image image);

    /**
     *
     * EntityList to Dto
     * (List< Image > to List< ImageMapping >)
     */
    List<ImageMapping> entityListToDto(List<Image> images);
}
