package com.dareshuri.libralink.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.BooksGenres;
import com.dareshuri.libralink.Repository.BooksGenresRepo;
import com.dareshuri.libralink.Service.BooksGenresService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BooksGenresSeviceImpl implements BooksGenresService{

    @Autowired
    BooksGenresRepo booksGenresRepo;

    // CREATE
    @Override
    public BooksGenres addBooksGenres(BooksGenres booksGenres) {
        return booksGenresRepo.save(booksGenres);
    }

    // READ
    @Override
    public Iterable<BooksGenres> getAllBookGenres() {
        return booksGenresRepo.findAll();
    }

    @Override
    public Optional<BooksGenres> getBooksGenresById(Long booksGenresId) {
        return booksGenresRepo.findById(booksGenresId);
    }

    @Override
    public List<BooksGenres> getBooksGenresByBookId(Long bookId) {
        return booksGenresRepo.findAllByBookId(bookId);
    }

    @Override
    public List<BooksGenres> getBooksGenresByGenreId(Long genreId) {
        return booksGenresRepo.findAllByGenreId(genreId);
    }

    // DELETE
    @Override
    public String deleteBooksGenresById(Long booksGenresId) {
         Optional<BooksGenres> booksGenresToDeleteOptional = booksGenresRepo.findById(booksGenresId);

        if (booksGenresToDeleteOptional.isPresent()) {
            BooksGenres booksGenresToDelete = booksGenresToDeleteOptional.get();
            booksGenresRepo.delete(booksGenresToDelete);
            return String.format("Books Genres with id %d successfully deleted!", booksGenresToDelete.getBooksGenresId());
        }
        return String.format("Books Genres not found!");
    }
    
}
