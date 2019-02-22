package com.service.entities.dto.util;

import com.persistence.entities.impl.CustomerEntity;
import com.service.entities.dto.CustomerDto;

public final class CustomerConverter {

	public static CustomerEntity getUserEntity(CustomerDto dto) {
		return new CustomerEntity(dto.getModifiedBy(), dto.getFirstName(), dto.getLastName(), dto.getEmail());
	}

	public static CustomerDto getUserEntity(CustomerEntity customerEntity) {
		return new CustomerDto(customerEntity.getFirstName(), customerEntity.getLastName(), customerEntity.getEmail(),
				customerEntity.getModifiedNameBy());
	}

}
