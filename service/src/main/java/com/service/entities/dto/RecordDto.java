package com.service.entities.dto;

public class RecordDto {

	private String amount;

	private String balance;

	private TransnationalTypeDto typeDto;
	
	private String changedBy;
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public TransnationalTypeDto getTypeDto() {
		return typeDto;
	}

	public void setTypeDto(TransnationalTypeDto typeDto) {
		this.typeDto = typeDto;
	}
	
	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	@Override
	public String toString() {
		return String.format("RecordDto [amount=%s, balance=%s, typeDto=%s]", amount, balance, typeDto);
	}

}
