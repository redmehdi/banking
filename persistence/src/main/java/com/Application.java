package com;


import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.persistence.entities.impl.AccountEntity;
import com.persistence.entities.impl.CustomerEntity;
import com.persistence.entities.respository.CustomerRepository;

@SpringBootApplication
@ComponentScan({"com.*"})
@EntityScan("com.*")
@EnableJpaRepositories("com.*")
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

//	@Bean
//	public CommandLineRunner demo(CustomerRepository repository) {
//		return (args) -> {
//			// save a couple of customers
//			CustomerEntity customer1 = new CustomerEntity("Redouane", "Redouane", "User1", "LastUser1", "sad@sdsad.com");
//			AccountEntity accountFirst = new AccountEntity("redouane", "Redouane", BigDecimal.valueOf(233424233), "EURO");
//			customer1.setAccount(accountFirst);
//			repository.save(customer1);
//			CustomerEntity customer2 = new CustomerEntity("Redouane", "Redouane", "User2", "LastUser2", "sad2@sdsad.com");
//			customer2.setAccount(new AccountEntity("redouane", "Redouane", BigDecimal.valueOf(233424233), "MAD"));
//			repository.save(customer2);
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (CustomerEntity customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			repository.findById(1L)
//				.ifPresent(customer -> {
//					log.info("Customer found with findById(1L):");
//					log.info("--------------------------------");
//					log.info(customer.toString());
//					log.info("");
//				});
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('User1'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("User1").forEach(User1 -> {
//				log.info(User1.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			// 	log.info(bauer.toString());
//			// }
//			log.info("");
//		};
//	}

}
