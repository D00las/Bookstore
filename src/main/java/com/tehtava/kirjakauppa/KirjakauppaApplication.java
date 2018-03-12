package com.tehtava.kirjakauppa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tehtava.kirjakauppa.domain.Book;
import com.tehtava.kirjakauppa.domain.BookRepository;
import com.tehtava.kirjakauppa.domain.User;
import com.tehtava.kirjakauppa.domain.UserRepository;

@SpringBootApplication
public class KirjakauppaApplication {
	private static final Logger log = LoggerFactory.getLogger(KirjakauppaApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstore(BookRepository repository, UserRepository urepository) {
		return (args) -> {
			log.info("save books into the database");
			repository.save(new Book("House of Leaves", "Mark Z. Danielewski", 2000, "0-375-70376-4", 30));
			repository.save(new Book("Dragon Age: World of Thedas Volume 1", "Ben Gelinas", 2013, "978-1-61655-115-5", 40));
			
			User user1 = new User("d00las", "$2y$10$G4KXEcLxeObXJfmCO/3SXucA0Gpf7QOk3B2MeBt4sipcwa62N4M3m", "ADMIN");
			User user2 = new User("user", "$2y$10$G4KXEcLxeObXJfmCO/3SXucA0Gpf7QOk3B2MeBt4sipcwa62N4M3m", "USER");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
