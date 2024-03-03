package com.dareshuri.libralink.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Genre;
import com.dareshuri.libralink.Repository.GenreRepo;
import com.dareshuri.libralink.Service.GenreService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    @Autowired 
    GenreRepo genreRepo;

    // READ
    @Override
    public Iterable<Genre> getAllGenres() {
        return genreRepo.findAll();
    }

    @Override
    public Optional<Genre> getGenreById(Long id) {
        return genreRepo.findById(id);
    }

    // ADD
    @Override
    public Genre addGenre(Genre genre) {
        return genreRepo.save(genre);
    }

    // UPDATE
    @Override
    public Genre updateGenreNameById(Long id, String newName) {
        Optional<Genre> existingGenre = genreRepo.findById(id);
        if (existingGenre.isPresent()) {
            Genre genreToUpdate = existingGenre.get();
            genreToUpdate.setName(newName);
            return genreRepo.save(genreToUpdate);
        } else {
            return null; 
        }
    }

    // DELETE
    @Override
    public String deleteGenreById(Long id) {
        Optional<Genre> genreOptional = genreRepo.findById(id);

        if(genreOptional.isPresent()){
            Genre genreToDelete = genreOptional.get();
            genreRepo.delete(genreToDelete);
            return String.format("Genre with id %d successfully deleted!",id);
        }
        
        return String.format("Genre with id %d is not found!",id);

    }


    
}
