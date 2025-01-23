package assignment1.web;

import assignment1.service.Bookservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("demo.xml");

        Bookservice bookservice = context.getBean("bs", Bookservice.class);

        System.out.println(bookservice.getAllBooks());
        System.out.println(bookservice.getBookById(1));
    }
}
