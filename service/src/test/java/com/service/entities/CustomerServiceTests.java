package com.service.entities;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.persistence.entities.impl.AccountEntity;
import com.persistence.entities.impl.CustomerEntity;
import com.service.entities.dto.AccountDto;
import com.service.entities.dto.CustomerDto;
import com.service.entities.dto.RecordDto;
import com.service.entities.exception.UserAccountNotFoundException;
import com.service.process.transactional.TransactionalService;
import com.service.process.transactional.request.CreationUserAndAccountRequest;
import com.service.process.transactional.request.DepositRequest;
import com.service.process.transactional.request.WithdrawalRequest;
import com.service.process.transactional.response.extractMovementResponse;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan({ "com.*" })
@EntityScan("com.*")
@EnableJpaRepositories("com.*")
public class CustomerServiceTests {

	@Autowired
	private CustomerService<CustomerEntity, CustomerDto> customerService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private TransactionalService transactionalService;

	@Test
	public void testFindByLastName() {
		customerService.addOrUpdate(new CustomerDto("redouane", "mehdi", "Sys"));
		
		CustomerDto user = customerService.findByFirstLastName("redouane", "mehdi");

		assertThat(user).extracting(CustomerDto::getLastName).containsOnly("mehdi");
	}
	
	@Test
	public void testAddUserAndAccountCreation() {
		CreationUserAndAccountRequest request = new CreationUserAndAccountRequest();
		request.setFirstName("redouane");
		request.setLastName("mehdi");
		request.setEmail("redouane@esei.uvigo.es");
		request.setBalance("89654654654654");
		request.setCurrency("USD");
		request.setModifiedBy("AUTOTEST");
		transactionalService.createUserAndAccount(request );

		CustomerDto user = customerService.findByFirstLastName("redouane", "mehdi");
		
		assertThat(user).extracting(CustomerDto::getLastName).containsOnly("mehdi");
	}
	
	@Test
	public void testUserWithDrawal() {
		CreationUserAndAccountRequest request = new CreationUserAndAccountRequest();
		request.setFirstName("redouane");
		request.setLastName("mehdi");
		request.setEmail("redouane@esei.uvigo.es");
		request.setBalance("1000199");
		request.setCurrency("USD");
		request.setModifiedBy("AUTOTEST");
		transactionalService.createUserAndAccount(request);

		CustomerDto user = customerService.findByLastName("mehdi");


		WithdrawalRequest w = new WithdrawalRequest();
		w.setIdUserExt(user.getId());
		w.setChangedBy("AUTOtest");
		w.setRequestAmount("199");
		try {
			transactionalService.withDrawal(w );
		} catch (UserAccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<AccountDto> accountDtos = accountService.findByEmail("redouane@esei.uvigo.es");	
		assertThat(accountDtos).extracting(AccountDto::getRecord).isNotEmpty();
	}
	
	@Test
	public void testUserDeposit() {
		CreationUserAndAccountRequest request = new CreationUserAndAccountRequest();
		request.setFirstName("redouane");
		request.setLastName("mehdi");
		request.setEmail("redouane@esei.uvigo.es");
		request.setBalance("0");
		request.setCurrency("USD");
		request.setModifiedBy("AUTOTEST");
		transactionalService.createUserAndAccount(request);

		CustomerDto user = customerService.findByLastName("mehdi");


		DepositRequest w = new DepositRequest();
		w.setIdUser(user.getId());
		w.setChangedBy("AUTOtest");
		w.setAmount("199");
		try {
			transactionalService.deposit(w );
		} catch (UserAccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<AccountDto> accountDtos = accountService.findByEmail("redouane@esei.uvigo.es");	
		assertThat(accountDtos).extracting(AccountDto::getRecord).isNotEmpty();
	}
	
	@Test
	public void testUserExtractMovement() {
		CreationUserAndAccountRequest request = new CreationUserAndAccountRequest();
		request.setFirstName("redouane");
		request.setLastName("mehdi");
		request.setEmail("redouane@esei.uvigo.es");
		request.setBalance("0");
		request.setCurrency("USD");
		request.setModifiedBy("AUTOTEST");
		transactionalService.createUserAndAccount(request);

		CustomerDto user = customerService.findByLastName("mehdi");


		DepositRequest w = new DepositRequest();
		w.setIdUser(user.getId());
		w.setChangedBy("AUTOtest");
		w.setAmount("199");
		List<RecordDto> recodt2 = recordService.getAll();
		try {
			transactionalService.deposit(w );
//			transactionalService.deposit(w );
//			transactionalService.deposit(w );
		} catch (UserAccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<RecordDto> recodt1 = recordService.getAll();
		
		try {
			extractMovementResponse extract = transactionalService.extractTransaction(user.getId());
		} catch (UserAccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		List<AccountDto> accountDtos = accountService.findByEmail("redouane@esei.uvigo.es");	
//		assertThat(accountDtos).extracting(AccountDto::getRecord).isNotEmpty();
	}
}
