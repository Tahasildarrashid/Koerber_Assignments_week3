package Bookstore.factory;
import java.util.Properties;
import java.io.*;
import java.sql.*;

public class ConnectionFactory {

    private static Connection connection = null;

    public static Connection getConnection()
    {
        InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconn.properties");
        Properties properties = new Properties();
        try{
            properties.load(is);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        String url=properties.getProperty("jdbc.url");
        String username=properties.getProperty("jdbc.username");
        String password=properties.getProperty("jdbc.password");
        String driverName=properties.getProperty("jdbc.drivername");

        try{
            Class.forName(driverName);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("some problem with driver");
        }

        try{
            connection = DriverManager.getConnection(url, username, password);
        }catch (SQLException e)
        {
            System.out.println("Issue with connection");
        }
        return connection;
    }


}
