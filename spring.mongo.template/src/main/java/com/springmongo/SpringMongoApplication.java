package com.springmongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringMongoApplication implements CommandLineRunner {
	Logger logger= LoggerFactory.getLogger(SpringMongoApplication.class);
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		try {
			userRepository.deleteAll();

			userRepository.save(new User("a", "aaa", "bbb1", 33, "a@a.com"));
			userRepository.save(new User("b", "bbb", "bbb2", 33, "a@a.com"));
			userRepository.save(new User("c", "ccc", "bbb3", 33, "a@a.com"));

			Optional<User> a = userRepository.findById("a");
			logger.info(a.get().toString());

			userRepository.findAll().stream()
					.forEach(ab -> logger.info(ab.toString()));

			logger.info(userRepository.findByFirstName("bbb").get().toString());
		}catch (Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
}
