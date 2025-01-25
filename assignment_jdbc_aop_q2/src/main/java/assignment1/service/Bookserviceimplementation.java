package assignment1.service;

import assignment1.custom_annotations.Loggable;
import assignment1.repository.Book;
import assignment1.repository.Bookdao;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Getter
@Setter
@Service(value = "bs")
public class Bookserviceimplementation implements Bookservice {

    @Autowired
    private Bookdao dao;

    public Bookserviceimplementation(Bookdao dao) {
        this.dao = dao;
    }

    @Loggable
    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Loggable
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
