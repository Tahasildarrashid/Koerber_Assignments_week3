package assignment1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Repository(value = "brjdbc")
@Primary
public class Bookdaojdbcimpl implements Bookdao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Bookdaojdbcimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT * FROM bookstore", new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book addBook(Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO bookstore(isbn, title, author, price) VALUES(?, ?, ?, ?)",
                    new String[]{"id"});
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setDouble(4, book.getPrice());
            return ps;
        }, keyHolder);

        book.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return book;
    }

    @Override
    public void deleteBook(int id) {
        String sql = "DELETE FROM bookstore WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateBook(int id, Book book) {
        String sql = "UPDATE bookstore SET isbn = ?, title = ?, author = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice(), id);
    }

    @Override
    public Book getBookById(int id) {
        String sql = "SELECT * FROM bookstore WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }
}