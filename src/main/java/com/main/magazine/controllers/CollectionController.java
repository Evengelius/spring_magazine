package com.main.magazine.controllers;

import com.main.magazine.errors.NotFoundException;
import com.main.magazine.mapper.CollectionMapper;
import com.main.magazine.mapping.CollectionMapping;
import com.main.magazine.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/collections")
public class CollectionController {

    private final CollectionMapper collectionMapper;
    private final CollectionService collectionService;

    @Autowired
    public CollectionController(CollectionMapper collectionMapper, CollectionService collectionService) {
        this.collectionMapper = collectionMapper;
        this.collectionService = collectionService;
    }


    // ******************************* GET ******************************* //

    // Collection | Find All
    @GetMapping
    public List<CollectionMapping> findAll() throws NotFoundException {
        return this.collectionMapper.entityListToDto(collectionService.findAll());
    }
}
