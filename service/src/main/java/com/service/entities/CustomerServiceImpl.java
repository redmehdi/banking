package com.service.entities;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.persistence.entities.impl.CustomerEntity;
import com.persistence.entities.respository.CustomerRepository;
import com.service.entities.dto.CustomerDto;
import com.service.entities.dto.util.CustomerConverter;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Transactional
	public void addCustomer(CustomerDto dto) {
		customerRepository.save(CustomerConverter.getUserEntity(dto));
	}

	public CustomerDto findByEmail(String name) {
		List<CustomerEntity> customerEntity = customerRepository.findByLastName(name);
		return CustomerConverter.getUserDto(customerEntity.get(0));
	}

	@Override
	public CustomerDto findById(String idExt) {
		final List<CustomerEntity> userEntity = customerRepository.findByIdExt(idExt);
		return !userEntity.isEmpty() ? CustomerConverter.getUserDto(userEntity.get(0)) : null;
	}

	@Override
	public CustomerDto findByFirstLastName(String firstName, String lastName) {
		final List<CustomerEntity> customerEntity = customerRepository.findByFirstLastName(firstName, lastName);
		return !customerEntity.isEmpty() ? CustomerConverter.getUserDto(customerEntity.get(0)) : null;
	}

}
