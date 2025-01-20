package Bookstore.service;

import Bookstore.repository.Book;

import java.util.List;

public interface BookstoreService {
    public List<Book> getAllBooks()throws RuntimeException;
    public Book addBook(Book book) throws RuntimeException;
    public void deleteBook(int id) throws RuntimeException;
    public void updateBook(int id, Book book) throws RuntimeException;
    public Book getBookById(int id) throws RuntimeException;
}
