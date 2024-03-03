package com.dareshuri.libralink.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dareshuri.libralink.Model.BooksGenres;

@Repository
public interface BooksGenresRepo extends CrudRepository<BooksGenres, Long>{
    // READ
    List<BooksGenres> findAllByBookId(Long bookId);
    List<BooksGenres> findAllByGenreId(Long genreId);
}
