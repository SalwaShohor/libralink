package com.dareshuri.libralink.Model;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books_genres")
public class BooksGenres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booksGenresId;
    @NotBlank
    private Long bookId;
    @NotBlank
    private Long genreId;

    public void setBooksGenresId(Long booksGenresId) {
        this.booksGenresId = booksGenresId;
    }

    public Long getBooksGenresId() {
        return booksGenresId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public Long getGenreId() {
        return genreId;
    }    
}
