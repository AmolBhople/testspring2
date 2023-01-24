package com.springpostgres;

import com.springpostgres.model.Address;
import com.springpostgres.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPostgresApplication implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(SpringPostgresApplication.class);

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringPostgresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		addressRepository.save(new Address(1L,"erer","fdgfdg",233, "reterfd"));
	}
}
