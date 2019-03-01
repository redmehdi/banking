package com.service.entities.dto.util;

import com.persistence.entities.impl.CustomerEntity;
import com.service.entities.dto.CustomerDto;

public final class CustomerConverter {

	public static CustomerEntity getUserEntity(CustomerDto dto) {
		return new CustomerEntity(dto.getModifiedBy(), dto.getModifiedBy(), dto.getFirstName(), dto.getLastName());
	}

	public static CustomerDto getUserDto(CustomerEntity customerEntity) {
		return new CustomerDto(customerEntity.getIdExt(), customerEntity.getFirstName(), customerEntity.getLastName(),
				customerEntity.getModifiedNameBy());
	}

}
