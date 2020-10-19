package com.main.magazine.services;

import com.main.magazine.errors.NotFoundException;
import com.main.magazine.model.Collection;
import com.main.magazine.repositories.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    private final CollectionRepository collectionRepository;

    @Autowired
    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    // ******************************* METHODS ******************************* //

    /* ******** Find | All ********** */
    public List<Collection> findAll() throws NotFoundException {
        List<Collection> collections = this.collectionRepository.findAll();
        if (collections.isEmpty()) {
            throw new NotFoundException("Cannot find the stream of collections.");
        } else {
            return collections;
        }
    }
}
