package com.main.magazine.controllers;

import com.main.magazine.errors.NotFoundException;
import com.main.magazine.mapper.ImageMapper;
import com.main.magazine.mapping.ImageMapping;
import com.main.magazine.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageMapper imageMapper;
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageMapper imageMapper, ImageService imageService) {
        this.imageMapper = imageMapper;
        this.imageService = imageService;
    }

    // ******************************* GET ******************************* //

    // Image | Find All
    @GetMapping
    public List<ImageMapping> findAll() throws NotFoundException {
        return this.imageMapper.entityListToDto(imageService.findAll());
    }
}
