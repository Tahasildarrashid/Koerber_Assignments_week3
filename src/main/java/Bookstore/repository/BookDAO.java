package Bookstore.repository;

import Bookstore.exceptions.BookNotFoundException;
import java.util.*;

public interface BookDAO {
    public List<Book> getAllBooks()throws BookNotFoundException;
    public Book addBook(Book book) throws BookNotFoundException;
    public void deleteBook(int id) throws BookNotFoundException;
    public void updateBook(int id, Book book) throws BookNotFoundException;
    public Book getBookById(int id) throws BookNotFoundException;
}
