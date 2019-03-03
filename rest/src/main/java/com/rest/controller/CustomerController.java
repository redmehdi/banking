package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.persistence.entities.impl.CustomerEntity;
import com.service.entities.CustomerService;
import com.service.entities.dto.CustomerDto;
import com.service.entities.exception.UserAccountNotFoundException;
import com.service.process.transactional.TransactionalService;
import com.service.process.transactional.request.CreationAccountRequest;
import com.service.process.transactional.request.CreationUserAndAccountRequest;
import com.service.process.transactional.request.CreationUserRequest;
import com.service.process.transactional.request.DepositRequest;
import com.service.process.transactional.request.WithdrawalRequest;

@RestController
public class CustomerController {

	@Autowired
	private final TransactionalService service;
	
	@Autowired
	private CustomerService<CustomerEntity, CustomerDto> customerService;

	public CustomerController(TransactionalService service) {
		this.service = service;
	}


	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/add")
	public @ResponseStatus(value = HttpStatus.CREATED) void newCustomer(@RequestBody CreationUserRequest newCustomer) {

		service.createUser(newCustomer);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/addUserAccount")
	public @ResponseStatus(value = HttpStatus.CREATED) void newCustomerWithAccount(
			@RequestBody CreationUserAndAccountRequest creationUserAndAccountRequest) {

		service.createUserAndAccount(creationUserAndAccountRequest);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/addAccount")
	public @ResponseStatus(value = HttpStatus.CREATED) void newAccount(@RequestBody CreationAccountRequest creationAccountRequest) {
		try {
			service.createAcount(creationAccountRequest);
		} catch (UserAccountNotFoundException e) {
			// TODO Auto-generated catch block
		}

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/withdrawal")
	public @ResponseStatus(value = HttpStatus.CREATED) void newWithdrawal(@RequestBody WithdrawalRequest withdrawalRequest) {
		try {
			service.withDrawal(withdrawalRequest);
		} catch (UserAccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/deposit")
	public @ResponseStatus(value = HttpStatus.CREATED) void newDeposit(@RequestBody DepositRequest depositRequest) {
		try {
			findId(depositRequest);
			service.deposit(depositRequest);
		} catch (UserAccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	/**
	 * This is only for unit test it can be improved depend on requirement and blueprint
	 * 
	 * @param depositRequest
	 */
	private void findId(DepositRequest depositRequest) {
		if (depositRequest.getIdUser() ==null || depositRequest.getIdUser().equals("")) {
			CustomerDto CustomerDto = customerService.findByFirstLastName(depositRequest.getFirstName(), depositRequest.getLastName());
			depositRequest.setIdUser(CustomerDto.getId());
			
		}
	}

}
