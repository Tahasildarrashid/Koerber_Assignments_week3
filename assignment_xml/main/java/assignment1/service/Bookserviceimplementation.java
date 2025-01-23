package assignment1.service;

import assignment1.repository.Book;
import assignment1.repository.Bookdao;
import assignment1.repository.Bookdaoimpl;
import lombok.Data;
import java.util.*;

@Data
public class Bookserviceimplementation implements Bookservice {
    private Bookdao dao;

    public Bookdao getDao()
    {
        return dao;
    }

    public void setDao(Bookdao dao) {
        this.dao = dao;
    }

    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        dao.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        dao.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return dao.getBookById(id);
    }

}
