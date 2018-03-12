package com.tehtava.kirjakauppa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tehtava.kirjakauppa.bean.Book;
import com.tehtava.kirjakauppa.bean.BookRepository;

@SpringBootApplication
public class KirjakauppaApplication {
	private static final Logger log = LoggerFactory.getLogger(KirjakauppaApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstore(BookRepository repository) {
		return (args) -> {
			log.info("save books into the database");
			repository.save(new Book("House of Leaves", "Mark Z. Danielewski", 2000, "0-375-70376-4", 30));
			repository.save(new Book("Dragon Age: World of Thedas Volume 1", "Ben Gelinas", 2013, "978-1-61655-115-5", 40));
		
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
	
}
