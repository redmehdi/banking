package com.service.entities.dto.util;

import java.util.ArrayList;
import java.util.List;

import com.persistence.entities.impl.AccountEntity;
import com.persistence.entities.impl.CustomerEntity;
import com.persistence.entities.impl.RecordEntity;
import com.service.entities.dto.AccountDto;
import com.service.entities.dto.CustomerDto;
import com.service.entities.dto.RecordDto;

public final class AccountConverter {

	public static AccountEntity getEntity(AccountDto dto) {
		return new AccountEntity(dto.getModifiedNameBy(), dto.getBalance(), dto.getCurrency());
	}

	public static AccountDto getDto(AccountEntity entity) {

		final CustomerEntity customerEntity = entity.getCustomer();
		final CustomerDto customerDto = customerEntity != null ? new CustomerDto(customerEntity.getFirstName(),
				customerEntity.getLastName(), customerEntity.getEmail(), customerEntity.getCreatedNameBy()) : null;

		List<RecordDto> recordDtos = new ArrayList<RecordDto>();

		final List<RecordEntity> recordEntities = entity.getRecords();
		if (recordEntities != null && !recordEntities.isEmpty()) {
			recordEntities.forEach(record -> recordDtos
					.add(new RecordDto(record.getAmount(), record.getBalance(), record.getTransnationalType())));
		}

		return new AccountDto(customerDto, entity.getBalance(), entity.getCurrency(), recordDtos,
				entity.getModifiedNameBy());
	}

}
