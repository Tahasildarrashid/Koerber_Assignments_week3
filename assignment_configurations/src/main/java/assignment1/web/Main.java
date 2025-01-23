package assignment1.web;

import assignment1.config.AutoConfig;
import assignment1.service.Bookservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AutoConfig.class);
        Bookservice bookservice = context.getBean("bs", Bookservice.class);
        System.out.println(bookservice.getAllBooks());
        System.out.println(bookservice.getBookById(2));
    }
}
