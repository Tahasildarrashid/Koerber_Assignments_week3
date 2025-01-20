package Bookstore.repository.Implementation;

import Bookstore.factory.ConnectionFactory;
import Bookstore.repository.Book;
import Bookstore.repository.BookDAO;
import java.sql.*;
import java.util.*;

public class BookDAOImplementation implements BookDAO {

    private Connection connection;

    public BookDAOImplementation(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<Book> getAllBooks()
    {
        List<Book> arr = new ArrayList<>();
        try{
            connection= ConnectionFactory.getConnection();
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from bookstore");
            while(rs.next()){
                arr.add(new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"),
                        rs.getString("author"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(connection != null){
                try{
                    connection.close();
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
        return arr;
    }

    @Override
    public Book addBook(Book b){
        try {
            connection= ConnectionFactory.getConnection();
            PreparedStatement preparedStatement=connection
                    .prepareStatement("insert into bookstore(isbn, title, author, price) values(?,?,?,?)");

            preparedStatement.setString(1,b.getIsbn());
            preparedStatement.setString(2,b.getTitle());
            preparedStatement.setString(3,b.getAuthor());
            preparedStatement.setDouble(4,b.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return b;
    }

    @Override
    public void deleteBook(int id){
        Book b = null;
        try {
            connection= ConnectionFactory.getConnection();
            PreparedStatement preparedStatement=connection
                    .prepareStatement("delete from bookstore where id=?");

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBook(int id, Book b){
        try
        {
            connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update bookstore set author = ? where id = ?");
            preparedStatement.setString(1, b.getAuthor());
            preparedStatement.setInt(2, b.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book getBookById(int id)
    {
        Book b = null;
        try {
            connection= ConnectionFactory.getConnection();
            PreparedStatement preparedStatement=connection
                    .prepareStatement("select * from emp where id=?");

            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                b = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"),
                        rs.getString("author"), rs.getDouble("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return b;
    }
}
