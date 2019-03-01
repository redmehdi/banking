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
				new RecordEntity("TESTAUTO", "TESTAUTO", BigDecimal.valueOf(9898), BigDecimal.valueOf(54),
						TransnationalType.DEPOSIT),
				new RecordEntity("TESTAUTO", "TESTAUTO", BigDecimal.valueOf(300), BigDecimal.valueOf(20),
						TransnationalType.WITHDRAWAL),
				new RecordEntity("TESTAUTO", "TESTAUTO", BigDecimal.valueOf(20), BigDecimal.valueOf(30),
						TransnationalType.DEPOSIT),
				new RecordEntity("TESTAUTO", "TESTAUTO", BigDecimal.valueOf(2323), BigDecimal.valueOf(243),
						TransnationalType.WITHDRAWAL) };
	}

}
