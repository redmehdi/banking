package com.service.entities.converter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.base.converter.BaseConverter;
import com.persistence.entities.impl.AccountEntity;
import com.persistence.entities.impl.CustomerEntity;
import com.service.entities.dto.AccountDto;
import com.service.entities.dto.CustomerDto;

@ComponentScan({ "com.*" })
@Component
public class CustomerConverter extends BaseConverter<CustomerEntity, CustomerDto> {

	private AccountConverter accountconverter;

	@Override
	public CustomerDto getDto(CustomerEntity e) {
		accountconverter = new AccountConverter();
		final CustomerDto customerDto = new CustomerDto(e.getIdExt(), e.getFirstName(), e.getLastName(), e.getModifiedNameBy());
		final AccountEntity accountDto = e.getAccount();
		if (accountDto != null) {
			customerDto.setAccountDto(accountconverter.getDto(accountDto));
		}
		return customerDto;
	}

	@Override
	public CustomerEntity getEntity(CustomerDto t) {
		accountconverter = new AccountConverter();
		final String modifiedBy = t.getModifiedBy();
		final AccountDto accountDto = t.getAccountDto();
		final String firstName = t.getFirstName();
		final String lastName = t.getLastName();
		final AccountEntity accountEntity = accountDto != null ? accountconverter.getEntity(accountDto) : null;

		// for new registration
		if (t.getId() == null) {
			final CustomerEntity customerEntity = new CustomerEntity(modifiedBy, modifiedBy, firstName, lastName);
			customerEntity.setAccount(accountEntity);
			return customerEntity;
		}
		// for update
		CustomerEntity customerEntity = new CustomerEntity(modifiedBy, firstName, lastName);
		customerEntity.setAccount(accountEntity);
		return customerEntity;
	}

}
