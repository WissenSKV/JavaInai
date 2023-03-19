package com.example.kurzwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
@Controller

public class KurzworkApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(KurzworkApplication.class, args);
//	}
@Autowired
transient CustomerRepository repository;
	@GetMapping("/")
	public String greeting() {

		log.info("hello--");
		//repository.save(new Customer("Chloe", "O'Brian"));
		//repository.save(new Customer("Kim", "Bauer"));
		System.out.println();
		return "greeting";
	}



	private static final Logger log = LoggerFactory.getLogger(KurzworkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KurzworkApplication.class);
		/*

		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));

		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
		}
		log.info("");

		// fetch an individual customer by ID
		Customer customer = repository.findById(1L);
		log.info("Customer found with findById(1L):");
		log.info("--------------------------------");
		log.info(customer.toString());
		log.info("");

		// fetch customers by last name
		log.info("Customer found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		repository.findByLastName("Bauer").forEach(bauer -> {
			log.info(bauer.toString());
		});
		// for (Customer bauer : repository.findByLastName("Bauer")) {
		//  log.info(bauer.t0oString());
		// }
		log.info("");*/
	}
}

