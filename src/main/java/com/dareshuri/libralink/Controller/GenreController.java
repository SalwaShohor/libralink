package com.dareshuri.libralink.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dareshuri.libralink.Model.Genre;
import com.dareshuri.libralink.Service.GenreService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/genre")
public class GenreController {

     @Autowired
    GenreService genreService;


    //READ
    @GetMapping("/get-all")
    Iterable<Genre> getAllUsers(){
        return genreService.getAllGenres();
    }

    @GetMapping("get-by-id/{id}")
    public Optional<Genre> getGenreById(@PathVariable Long id) {
        return genreService.getGenreById(id);
    }


        // ADD
    @PostMapping("/add")
    public Genre addGenre(@RequestBody Genre genre) {
        return genreService.addGenre(genre);
    }


        // UPDATE
    @PutMapping("/update-genre-name-by-id/{id}")
    public Genre updateGenre(@PathVariable Long id, @RequestParam String genreName) {
        return genreService.updateGenreNameById(id, genreName);
    }

    // DELETE
    @DeleteMapping("/delete-by-id/{id}")
    public String deleteGenre(@PathVariable Long id) {
        return genreService.deleteGenreById(id);
    }


    
}
