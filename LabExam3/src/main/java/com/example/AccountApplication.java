package com.example;

import com.example.entity.AccountEntity;
import com.example.repository.Bankdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	@Autowired
	private Bankdao Bankdao;

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Bankdao.save(new AccountEntity("Rashid T Tahasildar", 1000.0));
		Bankdao.save(new AccountEntity("Sumith S", 1000.0));
	}
}
