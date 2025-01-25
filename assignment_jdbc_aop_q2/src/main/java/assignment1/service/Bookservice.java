package assignment1.service;

import assignment1.repository.Book;

import java.util.List;

public interface Bookservice {
    public List<Book> getAllBooks();
    public Book addBook(Book book);
    public void deleteBook(int id);
    public void updateBook(int id, Book book);
    public Book getBookById(int id);
}
