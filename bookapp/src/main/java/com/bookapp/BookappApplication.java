package com.bookapp;

import com.bookapp.entity.Book;
import com.bookapp.repository.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.math.BigDecimal;

@SpringBootApplication
public class BookappApplication implements CommandLineRunner {
	@Autowired
	private Bookrepository bookrepository;

	private Logger logger = LoggerFactory.getLogger(BookappApplication.class);

	@Autowired
	private DataSource dataSource;
	public static void main(String[] args) {
		SpringApplication.run(BookappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Application started");
		logger.info("{}", bookrepository.findAll());

//		bookrepository.save(new Book("123456789", "Book 1", "Category 1", "Author 1", new BigDecimal(9.99)));
//		bookrepository.save(new Book("987654321", "Book 2", "Category 2", "Author 2", new BigDecimal(12.99)));
//		bookrepository.save(new Book("555555555", "Book 3", "Category 3", "Author 3", new BigDecimal(14.99)));
//		bookrepository.save(new Book("666666666", "Book 4", "Category 4", "Author 4", new BigDecimal(15.99)));
	}

}
