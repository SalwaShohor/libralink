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
     Genre addGenre(Genre genre);

     // UPDATE
     Genre updateGenreNameById(Long id, String newName);
 
     // DELETE
     String deleteGenreById(Long id);

    
    
}
