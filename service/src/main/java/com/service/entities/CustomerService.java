package com.service.entities;

import com.service.entities.dto.CustomerDto;

public interface CustomerService {

	void addCustomer(final CustomerDto user);

	CustomerDto findByEmail(final String email);

	CustomerDto findById(final String idExt);
	
	CustomerDto findByFirstLastName(final String firstName, final String lastName);

}
