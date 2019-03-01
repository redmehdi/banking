package com.service.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.entities.dto.CustomerDto;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan({ "com.*" })
@EntityScan("com.*")
@EnableJpaRepositories("com.*")
public class CustomerServiceTests {

	@Autowired
	private CustomerService customerService;

	@Test
	public void testFindByLastName() {
		customerService.addCustomer(new CustomerDto("redouane", "mehdi", "Sys"));

		CustomerDto user = customerService.findByFirstLastName("redouane", "mehdi");

		assertThat(user).extracting(CustomerDto::getLastName).containsOnly("mehdi");
	}
}
