package com.persistence.entities.repository.dataset;

import com.persistence.entities.impl.CustomerEntity;

public final class CustomerDataset {

	// Disallow construction
	private CustomerDataset() {
	}

	/**
	 * An array of five customers that should exist in the database. 
	 * 
	 * @return An array of four {@link CustomerEntity}
	 */
	public static CustomerEntity[] newCustomers() {
		return new CustomerEntity[] {
				new CustomerEntity("TESTSYS", "TESTSYS", "nameuser1", "lastname1", "email1@smtp.com"),
				new CustomerEntity("TESTSYS", "TESTSYS", "nameuser2", "lastname2", "email2@smtp.com"),
				new CustomerEntity("TESTSYS", "TESTSYS", "nameuser3", "lastname3", "email3@smtp.com"),
				new CustomerEntity("TESTSYS", "TESTSYS", "nameuser4", "lastname4", "email4@smtp.com"), };
	}

}
