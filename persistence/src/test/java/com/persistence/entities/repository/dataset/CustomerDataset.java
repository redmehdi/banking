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
				new CustomerEntity("TESTSYS", "TESTSYS", "nameuser1", "lastname1"),
				new CustomerEntity("TESTSYS", "TESTSYS", "nameuser2", "lastname2"),
				new CustomerEntity("TESTSYS", "TESTSYS", "nameuser3", "lastname3"),
				new CustomerEntity("TESTSYS", "TESTSYS", "nameuser4", "lastname4"),
				new CustomerEntity("TESTSYS", "TESTSYS", "nameuser4", "lastname4")};
	}

}
