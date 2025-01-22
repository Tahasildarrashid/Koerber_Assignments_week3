package Bookstore.web;

import Bookstore.exceptions.BookNotFoundException;
import Bookstore.repository.Book;
import Bookstore.service.BookstoreService;
import Bookstore.service.BookstoreServiceImplementation;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookstoreService bookService = new BookstoreServiceImplementation();
        getAllBooks(bookService);

        Book newBook = new Book("Hundred", "The Art of Java Programming", "Alice Cooper", 49.99);
        bookService.addBook(newBook);
        getAllBooks(bookService);

        try {
            bookService.deleteBook(3);
        } catch (BookNotFoundException e) {
            System.out.println("Book not found.");
        }

        try {
            Book book = bookService.getBookById(2);
            book.setPrice(book.getPrice() + 100);
            bookService.updateBook(5, book);
        } catch (BookNotFoundException e) {
            System.out.println("Book not found.");
        }
        getAllBooks(bookService);
    }

    private static void getAllBooks(BookstoreService bookService) {
        bookService.getAllBooks().forEach(System.out::println);
    }

}
