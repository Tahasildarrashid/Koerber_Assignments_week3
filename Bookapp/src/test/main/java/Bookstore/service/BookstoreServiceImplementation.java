package Bookstore.service;

import Bookstore.exceptions.BookNotFoundException;
import Bookstore.repository.Book;
import Bookstore.repository.BookDAO;
import Bookstore.repository.BookDAOImplementation;

import java.util.List;

public class BookstoreServiceImplementation implements BookstoreService{
    BookDAO bookRepo = new BookDAOImplementation();
    @Override
    public List<Book> getAllBooks() {
        return bookRepo.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return  bookRepo.addBook(book);
    }

    @Override
    public boolean deleteBook(int id) throws BookNotFoundException {
        try {
            return bookRepo.deleteBook(id);
        } catch (BookNotFoundException e) {
            throw new BookNotFoundException("Book Not found");
        }
    }

    @Override
    public boolean updateBook(int id, Book book) throws BookNotFoundException {
        try {
            return bookRepo.updateBook(id, book);
        } catch (BookNotFoundException e) {
            throw new BookNotFoundException("Book Not found");
        }
    }

    @Override
    public Book getBookById(int id) throws BookNotFoundException {
        try {
            return bookRepo.getBookById(id);
        } catch (BookNotFoundException e) {
            throw new BookNotFoundException("Book Not found");
        }
    }
}
