package com.service.entities.dto;

import java.math.BigDecimal;
import java.util.List;

public class AccountDto {

	private BigDecimal balance;

	private String currency;

	private CustomerDto customer;
	
	private String modifiedNameBy;

	private List<RecordDto> records;
	
	public AccountDto(CustomerDto customer, BigDecimal balance, String currency, List<RecordDto> records, final String modifiedNameBy) {
		this.customer = customer;
		this.balance = balance;
		this.currency = currency;
		this.records = records;
		this.modifiedNameBy = modifiedNameBy;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<RecordDto> getRecords() {
		return records;
	}

	public void setRecords(List<RecordDto> records) {
		this.records = records;
	}
	
	public String getModifiedNameBy() {
		return modifiedNameBy;
	}

	public void setModifiedNameBy(String modifiedNameBy) {
		this.modifiedNameBy = modifiedNameBy;
	}

	@Override
	public String toString() {
		return String.format("AccountDto [balance=%s, currency=%s, customer=%s, records=%s]", balance, currency,
				customer, records);
	}

}
