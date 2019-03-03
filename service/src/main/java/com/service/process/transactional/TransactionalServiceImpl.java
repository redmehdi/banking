package com.service.process.transactional;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.util.UtilProcess;
import com.persistence.entities.impl.CustomerEntity;
import com.service.entities.AccountService;
import com.service.entities.CustomerService;
import com.service.entities.RecordService;
import com.service.entities.dto.AccountDto;
import com.service.entities.dto.CustomerDto;
import com.service.entities.dto.RecordDto;
import com.service.entities.dto.TransnationalTypeDto;
import com.service.entities.exception.UserAccountNotFoundException;
import com.service.process.transactional.request.CreationAccountRequest;
import com.service.process.transactional.request.CreationUserAndAccountRequest;
import com.service.process.transactional.request.CreationUserRequest;
import com.service.process.transactional.request.DepositRequest;
import com.service.process.transactional.request.WithdrawalRequest;
import com.service.process.transactional.response.extractMovementResponse;

@Service
public class TransactionalServiceImpl implements TransactionalService {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RecordService recordService;

	@Autowired
	private CustomerService<CustomerEntity, CustomerDto> customerService;

	@Override
	public void createAcount(CreationAccountRequest r) throws UserAccountNotFoundException {
		final BigDecimal balance = UtilProcess.stringToBigDecimal(r.getBalance());
		final String currency = r.getCurrency();
		final String email = r.getEmail();
		final String changedBy = r.getChangedBy();

		if (r.getUserId() == null) {
			throw new UserAccountNotFoundException("user does not exist; cannot create account without user");
		}

		CustomerDto customerEntity = customerService.findById(r.getUserId());
		customerEntity.setAccountDto(new AccountDto(null, balance, currency, email, changedBy));
		customerService.addOrUpdate(customerEntity);

	}

	@Override
	public String withDrawal(WithdrawalRequest w) throws UserAccountNotFoundException {

		final String idUserExt = w.getIdUserExt();
		final BigDecimal amount = UtilProcess.stringToBigDecimal(w.getRequestAmount());

		if (idUserExt == null || idUserExt.equals("")) {
			throw new UserAccountNotFoundException("id user cannot be empty");
		}

		// retrieve user with its account and checking the existant
		final CustomerDto customerDto = customerService.findById(idUserExt.trim());
		if (customerDto == null) {
			throw new UserAccountNotFoundException("user does not exist; cannot create account without existant user");
		}

		// Checking if the user has account
		final AccountDto accountDto = customerDto.getAccountDto();
		if (accountDto == null) {
			throw new UserAccountNotFoundException("account does not exist");
		}

		// user should have money more than the withdrawal
		final BigDecimal balance = accountDto.getBalance();
		final int compareTo = balance.compareTo(amount);
		if (compareTo < 0) {
			return "L'argent insuffisant";
		}

		// Discount money required
		final BigDecimal currentBalance = UtilProcess.discountMoney(amount, balance);

		// guardar historia de movimiento
		final String changedBy = w.getChangedBy();
		accountDto.setBalance(currentBalance);
		accountDto.setChangedBy(changedBy);
		accountDto.setRecord(new RecordDto(null, amount, currentBalance, TransnationalTypeDto.WITHDRAWAL, changedBy));
		accountService.addOrUpdate(accountDto);

		return "Successful you can take the money: " + w.getRequestAmount();

	}

	@Override
	public void deposit(DepositRequest d) throws UserAccountNotFoundException {
		final String id = d.getIdUser();
		final BigDecimal amount = UtilProcess.stringToBigDecimal(d.getAmount());
		CustomerDto customerEntity = customerService.findById(id);
		if (id == null || customerEntity ==null) {
			throw new UserAccountNotFoundException("user does not exist; cannot create account without user");
		}

		final AccountDto accountDto = customerEntity.getAccountDto();
		if (accountDto == null) {
			throw new UserAccountNotFoundException("account does not exist");
		}

		final BigDecimal currentBalance = accountDto.getBalance().add(amount);

		// guardar historia de movimiento
		final String changedBy = d.getChangedBy();
		accountDto.setBalance(currentBalance);
		accountDto.setChangedBy(changedBy);
		accountDto.setRecord(new RecordDto(null, amount, currentBalance, TransnationalTypeDto.DEPOSIT, changedBy));
		accountService.addOrUpdate(accountDto);

	}

	@Override
	public extractMovementResponse extractTransaction(String id) throws UserAccountNotFoundException {
		if (id == null) {
			throw new UserAccountNotFoundException("id user cannot be empty");
		}
		
		CustomerDto customerEntity = customerService.findById(id);
		
		
		if (customerEntity ==null) {
			throw new UserAccountNotFoundException("user does not exist; cannot create account without user");
		}
		final AccountDto accountDto = accountService.findById(customerEntity.getAccountDto().getId());
		return null;
	}

	@Override
	public void createUser(final CreationUserRequest r) {
		final String firstName = r.getFirstName();
		final String lastName = r.getLastName();
		final String modifiedBy = r.getModifiedBy();

		if (firstName == null || lastName == null || modifiedBy == null) {
			return;
		}
		customerService.addOrUpdate(new CustomerDto(firstName, lastName, modifiedBy));

	}

	@Override
	public void createUserAndAccount(CreationUserAndAccountRequest t) {

		final String firstName = t.getFirstName();
		final String lastName = t.getLastName();
		final String modifiedBy = t.getModifiedBy();
		final BigDecimal balance = UtilProcess.stringToBigDecimal(t.getBalance());
		final String email = t.getEmail();
		final String currency = t.getCurrency();

		if (firstName == null || lastName == null || modifiedBy == null || balance == null || email == null) {
			return;
		}

		final CustomerDto customerDto = new CustomerDto(firstName, lastName, modifiedBy);
		AccountDto accountDto = new AccountDto(null, balance, currency, email, modifiedBy);
		customerDto.setAccountDto(accountDto);
		customerService.addOrUpdate(customerDto);

	}

}
