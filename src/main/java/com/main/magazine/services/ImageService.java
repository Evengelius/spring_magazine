package com.main.magazine.services;

import com.main.magazine.errors.NotFoundException;
import com.main.magazine.model.Image;
import com.main.magazine.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    // ******************************* METHODS ******************************* //

    /* ******** Find | All ********** */
    public List<Image> findAll() throws NotFoundException {
        List<Image> images = this.imageRepository.findAll();
        if (images.isEmpty()) {
            throw new NotFoundException("Cannot find the stream of images.");
        } else {
            return images;
        }
    }
}
