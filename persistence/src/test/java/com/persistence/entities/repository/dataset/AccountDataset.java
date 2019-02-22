package com.persistence.entities.repository.dataset;

import java.math.BigDecimal;

import com.persistence.entities.impl.AccountEntity;

public final class AccountDataset {

	// Disallow construction
	private AccountDataset() {
	}

	/**
	 * An array of five accounts that should exist in the database. 
	 * 
	 * @return An array of four {@link AccountEntity}
	 */
	public static AccountEntity[] newAccounts() {
		return new AccountEntity[] {
				new AccountEntity("TESTSYS", "TESTSYS", BigDecimal.valueOf(233424233),"EURO"),
				new AccountEntity("TESTSYS", "TESTSYS", BigDecimal.valueOf(1111),"MAD"),
				new AccountEntity("TESTSYS", "TESTSYS", BigDecimal.valueOf(424233),"USD"),
				new AccountEntity("TESTSYS", "TESTSYS", BigDecimal.valueOf(88000),"EURO") };
	}

}
