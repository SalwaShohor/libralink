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
    public Genre addGenre(String name) {
        Genre genre = new Genre();
        genre.setName(name);
        return genreRepo.save(genre);
    }

    // UPDATE
    @Override
    public Genre updateGenre(Long id, String name) {
        Optional<Genre> optionalGenre = genreRepo.findById(id);
        if (optionalGenre.isPresent()) {
            Genre genre = optionalGenre.get();
            genre.setName(name);
            return genreRepo.save(genre);
        } else {
            return null; // Handle not found scenario
        }
    }

    // DELETE
    @Override
    public void deleteGenre(Long id) {
        genreRepo.deleteById(id);
    }


    
}
