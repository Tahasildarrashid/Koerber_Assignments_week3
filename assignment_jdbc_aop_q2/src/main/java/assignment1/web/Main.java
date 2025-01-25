package assignment1.web;

import assignment1.config.AppConfig;
import assignment1.config.AppConfig;
import assignment1.repository.Book;
import assignment1.service.Bookservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Bookservice bookservice = context.getBean("bs",Bookservice.class);
        bookservice.getAllBooks().forEach(System.out::println);
        context.close();

        bookservice.addBook(new Book("eleven", "hello world in c", "washington", 789.09));
        bookservice.getAllBooks().forEach(System.out::println);
    }
}
