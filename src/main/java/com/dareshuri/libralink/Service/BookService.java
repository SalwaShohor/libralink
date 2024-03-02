package com.dareshuri.libralink.Service;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Book;

@Service()
public interface BookService {

    // CREATE
    Book addBook(Book book);
    
    // READ
    Iterable<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
    Iterable<Book> getAllBooksByTitle(String title);
    Iterable<Book> getAllBooksByAuthor(String author);
    Iterable<Book> getAllBooksByGenre(String genre);

    // UPDATE
    Book updateBookInfoById(Long id, Map<String,String> inpMap) throws ParseException;

    // DELETE
    String deleteBookById(Long id);
    


    

}