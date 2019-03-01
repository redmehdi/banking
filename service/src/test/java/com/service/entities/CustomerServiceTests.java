package com.service.entities;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.entities.dto.AccountDto;
import com.service.entities.dto.CustomerDto;
import com.service.entities.dto.OperationalRequestDto;
import com.service.entities.dto.exception.UserAccountNotFoundException;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan({ "com.*" })
@EntityScan("com.*")
@EnableJpaRepositories("com.*")
public class CustomerServiceTests {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OperationalService operationalService;

	@Test
	public void testFindByLastName() {
		customerService.addCustomer(new CustomerDto("redouane", "mehdi", "Sys"));

		CustomerDto user = customerService.findByFirstLastName("redouane", "mehdi");

		assertThat(user).extracting(CustomerDto::getLastName).containsOnly("mehdi");
	}
	
	@Test
	public void testAddUserAndAccountCreation() {
		customerService.addCustomer(new CustomerDto("redouane", "mehdi", "Sys"));

		CustomerDto user = customerService.findByFirstLastName("redouane", "mehdi");
		
		try {
			operationalService.createAcount(new OperationalRequestDto(user.getId(), "sadad@smpt.es", null, BigDecimal.valueOf(5421), "USD", "REDAUTHO"));
		}
		catch (UserAccountNotFoundException e) {
			// TODO Auto-generated catch block
		}
		
		assertThat(user).extracting(CustomerDto::getLastName).containsOnly("mehdi");
	}
	
	@Test
	public void testUserWithDrawal() {
		customerService.addCustomer(new CustomerDto("redouane", "mehdi", "Sys"));

		CustomerDto user = customerService.findByFirstLastName("redouane", "mehdi");
		
		try {
			operationalService.createAcount(new OperationalRequestDto(user.getId(), "sadad@smpt.es", null, BigDecimal.valueOf(5421), "USD", "REDAUTHO"));
		}
		catch (UserAccountNotFoundException e) {
			// TODO Auto-generated catch block
		}
		
		try {
			operationalService.withDrawal(new OperationalRequestDto(user.getId(), "sadad@smpt.es", BigDecimal.valueOf(21), null, "USD", "REDAUTHO"));
		}
		catch (UserAccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CustomerDto userEmail = customerService.findByFirstLastName("redouane", "mehdi");
		
		assertThat(userEmail.getAccountDto()).extracting(AccountDto::getBalance).containsOnly(BigDecimal.valueOf(5400));
	}
}
