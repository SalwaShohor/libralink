package com.dareshuri.libralink.Controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dareshuri.libralink.Model.Genre;
import com.dareshuri.libralink.Service.GenreService;


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
    public ResponseEntity<Genre> addDepartment(@RequestBody Map<String, String> requestBody) {
        String name = requestBody.get("name");
        Genre newGenre = genreService.addGenre(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(newGenre);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Map<String, String> genreDetails) {
        String name = genreDetails.get("name");
        Genre updatedGenre = genreService.updateGenre(id, name);
        return ResponseEntity.ok(updatedGenre);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
    }


    
}
