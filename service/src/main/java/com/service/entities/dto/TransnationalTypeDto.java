package com.service.entities.dto;

public enum TransnationalTypeDto {
	
	WITHDRAWAL("WITHDRAWAL"), DEPOSIT("DEPOSIT"), LOAN("LOAN");

	private final String text;

	TransnationalTypeDto(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
