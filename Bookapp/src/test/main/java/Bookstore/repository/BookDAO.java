package Bookstore.repository;

import Bookstore.exceptions.BookNotFoundException;
import java.util.*;

public interface BookDAO {
    List<Book> getAllBooks();
    Book addBook(Book book);
    boolean deleteBook(int id) throws BookNotFoundException;
    boolean updateBook(int id, Book book) throws BookNotFoundException;
    Book getBookById(int id) throws BookNotFoundException;
}