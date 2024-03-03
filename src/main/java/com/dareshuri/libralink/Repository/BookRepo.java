package com.dareshuri.libralink.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dareshuri.libralink.Model.Book;

@Repository
public interface BookRepo extends CrudRepository<Book,Long> {
    Iterable<Book> findAllByTitle(String title);
    Iterable<Book> findAllByAuthor(String author);
}
