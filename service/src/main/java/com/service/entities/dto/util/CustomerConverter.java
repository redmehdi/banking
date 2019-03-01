package com.service.entities.dto.util;

import com.persistence.entities.impl.AccountEntity;
import com.persistence.entities.impl.CustomerEntity;
import com.service.entities.dto.AccountDto;
import com.service.entities.dto.CustomerDto;

public final class CustomerConverter {

	public static CustomerEntity getUserEntity(final CustomerDto dto) {
		return new CustomerEntity(dto.getModifiedBy(), dto.getModifiedBy(), dto.getFirstName(), dto.getLastName());
	}

	public static CustomerDto getUserDto(final CustomerEntity customerEntity) {
		final CustomerDto customerDto = new CustomerDto(customerEntity.getIdExt(), customerEntity.getFirstName(),
				customerEntity.getLastName(), customerEntity.getModifiedNameBy());
		final AccountEntity account = customerEntity.getAccount();
		if (account != null) {
			customerDto.setAccountDto(new AccountDto(account.getBalance(), account.getCurrency(), account.getEmail()));
		}
		return customerDto;
	}

}
