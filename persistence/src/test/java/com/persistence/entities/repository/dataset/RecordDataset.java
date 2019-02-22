package com.persistence.entities.repository.dataset;

import java.math.BigDecimal;

import com.persistence.entities.impl.RecordEntity;
import com.persistence.entities.impl.TransnationalType;

public final class RecordDataset {

	// Disallow construction
	private RecordDataset() {
	}

	/**
	 * An array of five records that should exist in the database. 
	 * 
	 * @return An array of four {@link RecordEntity}
	 */
	public static RecordEntity[] newRecords() {
		return new RecordEntity[] {
				new RecordEntity(BigDecimal.valueOf(9898), BigDecimal.valueOf(0),
						TransnationalType.DEPOSIT, "TESTSYS", "TESTSYS"),
				new RecordEntity(BigDecimal.valueOf(300), BigDecimal.valueOf(20),
						TransnationalType.WITHDRAWAL, "TESTSYS", "TESTSYS"),
				new RecordEntity(BigDecimal.valueOf(20), BigDecimal.valueOf(30),
						TransnationalType.DEPOSIT, "TESTSYS", "TESTSYS"),
				new RecordEntity(BigDecimal.valueOf(2323), BigDecimal.valueOf(243),
						TransnationalType.WITHDRAWAL, "TESTSYS", "TESTSYS") };
	}

}
