package com.service.entities;

import com.service.entities.dto.CustomerDto;

public interface CustomerService {
	
	void addUser(CustomerDto user);
	
	CustomerDto getUserDto(String name);
	
	boolean withdrawal(Long id, Long amount);
	
	boolean despositMoney(Long id, Long amount);

}
