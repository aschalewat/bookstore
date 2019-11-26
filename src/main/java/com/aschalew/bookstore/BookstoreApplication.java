package com.aschalew.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		System.out.println("Bookstore Application");
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
