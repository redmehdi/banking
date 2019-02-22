package com.service.entities.dto;

import java.math.BigDecimal;

import com.persistence.entities.impl.TransnationalType;

public class RecordDto {
	
	private BigDecimal amount;

	private BigDecimal balance;

	private TransnationalType transnationalType;

	private AccountDto account;

	public RecordDto(BigDecimal amount, BigDecimal balance, TransnationalType transnationalType) {
		super();
		this.amount = amount;
		this.balance = balance;
		this.transnationalType = transnationalType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public TransnationalType getTransnationalType() {
		return transnationalType;
	}

	public void setTransnationalType(TransnationalType transnationalType) {
		this.transnationalType = transnationalType;
	}

	public AccountDto getAccount() {
		return account;
	}

	public void setAccount(AccountDto account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return String.format("RecordDto [amount=%s, balance=%s, transnationalType=%s, account=%s]", amount, balance,
				transnationalType, account);
	}
	
}
