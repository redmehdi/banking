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
	public void addUser(CustomerDto dto) {
		customerRepository.save(CustomerConverter.getUserEntity(dto));
	}
	
	public CustomerDto getUserDto(String name) {
		List<CustomerEntity> customerEntity = customerRepository.findByLastName(name);
		return CustomerConverter.getUserEntity(customerEntity.get(0));
	}

	public boolean withdrawal(Long id, Long amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean despositMoney(Long id, Long amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
