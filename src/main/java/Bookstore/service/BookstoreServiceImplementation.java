package Bookstore.service;

import Bookstore.exceptions.BookNotFoundException;
import Bookstore.repository.Book;
import Bookstore.repository.BookDAO;
import Bookstore.repository.Implementation.BookDAOImplementation;

import java.util.List;

public class BookstoreServiceImplementation implements BookstoreService{

    private BookDAO b = new BookDAOImplementation();
    @Override
    public List<Book> getAllBooks() throws RuntimeException {
        return b.getAllBooks();
    }

    @Override
    public Book addBook(Book book) throws RuntimeException {
        return b.addBook(book);
    }

    @Override
    public void deleteBook(int id) throws RuntimeException {
        b.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book) throws RuntimeException {
        b.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id) throws RuntimeException {
        Book book = b.getBookById(id);
        if(book != null)
            return book;
        else
            throw new BookNotFoundException(" Book with id "+ id +" is not found");
    }
}
