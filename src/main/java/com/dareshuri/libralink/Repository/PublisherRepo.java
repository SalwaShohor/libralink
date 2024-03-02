package com.dareshuri.libralink.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dareshuri.libralink.Model.Publisher;

@Repository
public interface PublisherRepo extends CrudRepository<Publisher,Long> {
    Optional<Publisher> findById(Long id);
}
