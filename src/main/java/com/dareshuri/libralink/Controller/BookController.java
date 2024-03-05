package com.dareshuri.libralink.Controller;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dareshuri.libralink.Model.Book;
import com.dareshuri.libralink.Service.BookService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/book")
public class BookController {
    
    @Autowired
    BookService bookService;

    // CREATE
    @PostMapping("/add")
    public Book addUser(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // READ
    @GetMapping("/get-all")
    public Iterable<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/get-by-id/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
    
    @GetMapping("/get-all-by-title/{title}")
    public Iterable<Book> getBookByTitle(@PathVariable String title) {
        return bookService.getAllBooksByTitle(title);
    }

    @GetMapping("/get-all-by-author/{author}")
    public Iterable<Book> getBookByAuthor(@PathVariable String author) {
        return bookService.getAllBooksByAuthor(author);
    }

    // UPDATE
    @PutMapping("update-info-by-id/{id}")
    public Book updateBookInfoById(@PathVariable Long id, @RequestBody Map<String,String> inpMap) throws ParseException {
        return bookService.updateBookInfoById(id, inpMap);
    }

    @DeleteMapping("delete-by-id/{id}")
    public String deleteBookById(@PathVariable Long id){
        return bookService.deleteBookById(id);
    }

}
