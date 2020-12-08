package com.masteril.book;

import com.masteril.book.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookApplication {

	@Bean
	public CommandLineRunner lineRunner(BookRepository repository) {
		return (args) -> {

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class);
	}

}
