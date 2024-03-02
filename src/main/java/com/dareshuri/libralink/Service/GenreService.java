package com.dareshuri.libralink.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Genre;

@Service()
public interface GenreService {

    // READ
    Iterable<Genre> getAllGenres();
    Optional<Genre> getGenreById(Long id);


     // ADD
     Genre addGenre(String name);

     // UPDATE
     Genre updateGenre(Long id, String name);
 
     // DELETE
     void deleteGenre(Long id);

    
    
}
