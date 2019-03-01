package com.service.entities.dto;

import java.math.BigDecimal;

public class AccountDto {

	private BigDecimal balance;

	private String currency;

	private String email;

	public AccountDto(BigDecimal balance, String currency, String email) {
		super();
		this.balance = balance;
		this.currency = currency;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("AccountDto [balance=%s, currency=%s, email=%s]", balance, currency, email);
	}

}
