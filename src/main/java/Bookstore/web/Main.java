package Bookstore.web;

import Bookstore.repository.Book;
import Bookstore.service.BookstoreService;
import Bookstore.service.BookstoreServiceImplementation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookstoreService b = new BookstoreServiceImplementation();
        List<Book> arr = b.getAllBooks();

        BookstoreService b1 = new BookstoreServiceImplementation();
        Book bookwasadded = b1.addBook(new Book(10,"hundred", "Stranger things", "Robert", 5000));

        BookstoreService b2 = new BookstoreServiceImplementation();
        b2.deleteBook(4);

        b2.updateBook(2, new Book(2, "eleven", "Wednesday", "Rashid T Tahasildar", 1234));
        arr.forEach(System.out::println);

    }
}
