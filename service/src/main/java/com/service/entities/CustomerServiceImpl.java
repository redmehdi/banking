package com.service.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.converter.BaseConverter;
import com.base.service.BaseService;
import com.persistence.entities.impl.CustomerEntity;
import com.persistence.entities.respository.CustomerRepository;
import com.service.entities.converter.CustomerConverter;
import com.service.entities.dto.CustomerDto;

@Service
public class CustomerServiceImpl extends BaseService<CustomerEntity, CustomerDto, CustomerRepository>
		implements CustomerService<CustomerEntity, CustomerDto> {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDto findByLastName(String lastName) {
		final List<CustomerEntity> findByLastName = customerRepository.findByLastName(lastName);
		if (findByLastName == null || findByLastName.isEmpty()) {
			return null;
		}
		return getConverter().getDto(findByLastName.get(0));
	}

	@Override
	public CustomerDto findByFirstLastName(String firstName, String lastName) {
		final List<CustomerEntity> findByFirstLastName = customerRepository.findByFirstLastName(firstName, lastName);
		if (findByFirstLastName == null || findByFirstLastName.isEmpty()) {
			return null;
		}
		return getConverter().getDto(findByFirstLastName.get(0));
	}

	@Override
	protected BaseConverter<CustomerEntity, CustomerDto> getConverter() {
		return new CustomerConverter();
	}

}
