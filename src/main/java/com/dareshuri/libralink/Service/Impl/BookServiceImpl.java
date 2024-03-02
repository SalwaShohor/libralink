package com.dareshuri.libralink.Service.Impl;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Book;
import com.dareshuri.libralink.Repository.BookRepo;
import com.dareshuri.libralink.Service.BookService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService  {

    @Autowired
    BookRepo bookRepo;

    // CREATE
    @Override
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    // READ
    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public Iterable<Book> getAllBooksByTitle(String title) {
        return bookRepo.findAllByTitle(title);
    }

    @Override
    public Iterable<Book> getAllBooksByAuthor(String author) {
        return bookRepo.findAllByAuthor(author);
    }

    @Override
    public Iterable<Book> getAllBooksByGenre(String genre) {
        return bookRepo.findAllByGenre(genre);
    }

    // UPDATE
    @Override
    public Book updateBookInfoById(Long id, Map<String, String> inpMap) throws ParseException{
        Optional<Book> bookOptional = bookRepo.findById(id);
        
        if(bookOptional.isPresent()){
            Book book = bookOptional.get();
            // SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            book.setQuantity(Integer.parseInt(inpMap.get("quantity")));
            book.setAvailableQuantity(Integer.parseInt(inpMap.get("availableQuantity")));
            book.setLocationId(Long.parseLong(inpMap.get("locationId")));
            // Date formattedDate = formatter.parse(inpMap.get("publishedDate"));
            // book.setPublishedDate(new Date(formattedDate.getTime() + (1000 * 60 * 60 * 24)));
            
            return bookRepo.save(book);
        }

        return null;
    }

    // DELETE
    @Override
    public String deleteBookById(Long id) {
        Optional<Book> bookOptional = bookRepo.findById(id);
        
        if(bookOptional.isPresent()){
            Book book = bookOptional.get();
            bookRepo.delete(book);
            return String.format("Book with id %d successfully deleted!", id);
        }

        return String.format("Book with id %d not found!", id);
    }
    
}
