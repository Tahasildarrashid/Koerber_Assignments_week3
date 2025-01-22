package Customer.factory;

import java.util.Properties;
import java.io.*;
import java.sql.*;

public class ConnectionFactory {

    private static Connection connection = null;

    public static Connection getConnection() {
        InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconn.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        String driverName = properties.getProperty("jdbc.drivername");

        try {
            System.out.println(driverName);
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection);
        } catch (Exception e) {
            System.out.println("Connection error");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }
}
