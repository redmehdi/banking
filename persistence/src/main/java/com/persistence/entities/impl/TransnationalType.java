package com.persistence.entities.impl;

public enum TransnationalType {

	WITHDRAWAL("WITHDRAWAL"), DEPOSIT("DEPOSIT"), LOAN("LOAN");

	private final String text;

	TransnationalType(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

}
