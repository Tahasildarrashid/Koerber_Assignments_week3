package Bookstore.service;

import Bookstore.exceptions.BookNotFoundException;
import Bookstore.repository.Book;
import java.util.List;

public interface BookstoreService {
    List<Book> getAllBooks();
    Book addBook(Book book);
    boolean deleteBook(int id) throws BookNotFoundException;
    boolean updateBook(int id, Book book) throws BookNotFoundException;
    Book getBookById(int id) throws BookNotFoundException;
}
