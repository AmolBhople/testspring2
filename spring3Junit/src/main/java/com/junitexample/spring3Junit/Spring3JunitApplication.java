package com.junitexample.spring3Junit;

import com.junitexample.spring3Junit.model.Address;
import com.junitexample.spring3Junit.model.User;
import com.junitexample.spring3Junit.repository.AddressRepository;
import com.junitexample.spring3Junit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Spring3JunitApplication implements CommandLineRunner {
 Logger logger= LoggerFactory.getLogger(Spring3JunitApplication.class);
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(Spring3JunitApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		addressRepository.save(new Address(1L, "Addr1", "city1"));
		addressRepository.save(new Address(4L, "Addr1", "city1"));
		addressRepository.save(new Address(2L, "Addr2", "city2"));
		addressRepository.save(new Address(3L, "Addr3", "city3"));

		addressRepository.findAll().stream().forEach(addd -> System.out.println(addd));

		System.out.println(addressRepository.findByCity("city1"));
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			userRepository.deleteAll();

			userRepository.save(new User("a", "aaa", "bbb1", 33, "a@a.com"));
			userRepository.save(new User("b", "bbb", "bbb2", 33, "a@a.com"));
			userRepository.save(new User("c", "ccc", "bbb3", 33, "a@a.com"));

			userRepository.findAll().stream().forEach(user -> System.out.println(user));

			System.out.println(userRepository.findByFirstName("bbb"));
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw e;
		}
	}
}
