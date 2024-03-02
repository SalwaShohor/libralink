package com.dareshuri.libralink.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.dareshuri.libralink.Model.Genre;
import java.util.Optional;

@Repository
public interface GenreRepo extends CrudRepository<Genre,Long> {
    
    Iterable<Genre> findAll();
    Optional<Genre> findById(Long genreId);
}
