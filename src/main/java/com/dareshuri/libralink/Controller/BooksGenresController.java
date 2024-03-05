package com.dareshuri.libralink.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dareshuri.libralink.Model.BooksGenres;
import com.dareshuri.libralink.Service.BooksGenresService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/books-genres")
public class BooksGenresController {
    
    @Autowired
    BooksGenresService booksGenresService;

    // CREATE
    @PostMapping("/add")
    public BooksGenres addBooksGenres(@RequestBody BooksGenres booksGenres){
        return booksGenresService.addBooksGenres(booksGenres);
    }

    // READ
    @GetMapping("/get-all")
    public Iterable<BooksGenres> getAllBooksGenres() {
        return booksGenresService.getAllBookGenres();
    }

    @GetMapping("/get-by-id/{booksGenresId}")
    public Optional<BooksGenres> getBooksGenresById(@PathVariable Long booksGenresId) {
        return booksGenresService.getBooksGenresById(booksGenresId);
    }

    @GetMapping("/get-all-by-book-id/{bookId}")
    public List<BooksGenres> getBooksGenresByBookId(@PathVariable Long bookId) {
        return booksGenresService.getBooksGenresByBookId(bookId);
    }
    
    @GetMapping("/get-all-by-genre-id/{genreId}")
    public List<BooksGenres> getBooksGenresByGenreId(@PathVariable Long genreId) {
        return booksGenresService.getBooksGenresByGenreId(genreId);
    }
    

    // DELETE
    @DeleteMapping("/delete-by-id/{booksGenresId}")
    public String deleteBooksGenresById(@PathVariable Long booksGenresId){
        return booksGenresService.deleteBooksGenresById(booksGenresId);
    }

}
