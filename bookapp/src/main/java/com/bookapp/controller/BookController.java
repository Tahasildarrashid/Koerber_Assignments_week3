package com.bookapp.controller;

import com.bookapp.entity.Book;
import com.bookapp.service.Bookservice;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private Bookservice bookservice;

    @Autowired
    public BookController(Bookservice bookservice) {
        this.bookservice = bookservice;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookservice.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookservice.getBookById(id);
    }

    @GetMapping("/books/save")
    public Book save(Book book) {
        return bookservice.save(book);
    }

    @GetMapping("/books/update/{id}")
    public Book updateBook(@PathVariable int id, Book book) {
        Book b1 = getBookById(id);
        b1.setId(id);
        b1.setPrice(book.getPrice());
        b1.setIsbn(book.getIsbn());
        b1.setTitle(book.getTitle());
        b1.setCategory(book.getCategory());
        b1.setAuthor(book.getAuthor());
        bookservice.save(b1);
        return b1;
    }

    @GetMapping("/books/delete/{id}")
    public void deleteBook(@PathVariable int id) {
        bookservice.deleteBook(id);
    }

}
