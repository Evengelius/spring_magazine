package com.main.magazine.repositories;

import com.main.magazine.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
    Collection findByName(String name);
}
