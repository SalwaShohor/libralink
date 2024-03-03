package com.dareshuri.libralink.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.BooksGenres;

@Service()
public interface BooksGenresService {
    
    // CREATE
    BooksGenres addBooksGenres(BooksGenres booksGenres);

    // READ
    Iterable<BooksGenres> getAllBookGenres();
    Optional<BooksGenres> getBooksGenresById(Long booksGenresId);
    List<BooksGenres> getBooksGenresByBookId(Long bookId);
    List<BooksGenres> getBooksGenresByGenreId(Long genreId);

    // DELETE 
    String deleteBooksGenresById(Long booksGenresId);
}
