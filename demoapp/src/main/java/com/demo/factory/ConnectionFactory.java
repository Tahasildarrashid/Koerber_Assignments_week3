package com.demo.factory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//factory of connection
public class ConnectionFactory {
    private static Connection connection=null;

    public static Connection getConnection(){

        InputStream is=ConnectionFactory
                .class.getClassLoader().getResourceAsStream("dbconn.properties");

        Properties properties=new Properties();
        try{
            properties.load(is);
        }catch (Exception e){
            e.printStackTrace();
        }

        String url=properties.getProperty("jdbc.url");
        String username=properties.getProperty("jdbc.username");
        String password=properties.getProperty("jdbc.password");
        String driverName=properties.getProperty("jdbc.drivername");

        try{
            System.out.println(driverName);
            Class.forName(driverName);
            System.out.println("driver is loaded");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            return DriverManager
                    .getConnection(url, username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Connection connection=ConnectionFactory.getConnection();
    }
}