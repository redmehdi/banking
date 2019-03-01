package com.service.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.persistence.entities.impl.AccountEntity;
import com.persistence.entities.impl.CustomerEntity;
import com.persistence.entities.impl.RecordEntity;
import com.persistence.entities.impl.TransnationalType;
import com.persistence.entities.respository.AccountRepository;
import com.persistence.entities.respository.CustomerRepository;
import com.service.entities.dto.OperationalRequestDto;
import com.service.entities.dto.exception.UserAccountNotFoundException;

@Component
public class OperationalServiceImpl implements OperationalService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void createAcount(OperationalRequestDto operationData) throws UserAccountNotFoundException {

		if (operationData.getId() == null) {
			throw new UserAccountNotFoundException("user does not exist; cannot create account without user");
		}

		CustomerEntity customerEntity = getCustomerEntity(operationData);

		// add account for user
		AccountEntity acount = new AccountEntity(operationData.getChangedBy(), operationData.getBalance(),
				operationData.getCurrency(), operationData.getEmail());
		customerEntity.setAccount(acount);
		customerRepository.save(customerEntity);
	}

	private CustomerEntity getCustomerEntity(OperationalRequestDto operationData) {
		List<CustomerEntity> customer = customerRepository.findByIdExt(operationData.getId());
		CustomerEntity customerEntity = customer != null ? customer.get(0) : null;
		return customerEntity;
	}

	@Override
	public String withDrawal(OperationalRequestDto operationData) throws UserAccountNotFoundException {
		if (operationData.getId() == null) {
			throw new UserAccountNotFoundException("user does not exist; cannot create account without user");
		}

		CustomerEntity customerEntity = getCustomerEntity(operationData);
		final AccountEntity account = customerEntity.getAccount();
		if (account == null) {
			throw new UserAccountNotFoundException("account does not exist");
		}

		// user should have money more than the withdrawal
		final int compareTo = account.getBalance().compareTo(operationData.getAmount());
		if (compareTo < 0) {
			return "L'argent insuffisant";
		}
		final BigDecimal balance = account.getBalance().subtract(operationData.getAmount());
		RecordEntity recordEntity = new RecordEntity(operationData.getChangedBy(), operationData.getChangedBy(),
				operationData.getAmount(), balance, TransnationalType.WITHDRAWAL);
		account.addRecored(recordEntity);
		accountRepository.save(account);
		return "cannot be created";

	}

	@Override
	public void deposit(OperationalRequestDto operationData) {
		// TODO Auto-generated method stub

	}

}
