package com.service.entities.dto;

import java.math.BigDecimal;

public class OperationalRequestDto {

	private String idUserExt;

	private String email;

	private BigDecimal amount;

	private BigDecimal balance;

	private String changedBy;

	private String currency;

	public OperationalRequestDto(String id, String email, BigDecimal amount, BigDecimal balance,
			TransnationalTypeDto transnationalType, final String changedBy) {
		this.idUserExt = id;
		this.email = email;
		this.amount = amount;
		this.balance = balance;
		this.changedBy = changedBy;
	}

	public OperationalRequestDto(String email, BigDecimal amount, BigDecimal balance,
			TransnationalTypeDto transnationalType, final String changedBy) {
		this(null, email, amount, balance, transnationalType, changedBy);
	}

	public String getId() {
		return idUserExt;
	}

	public void setId(String id) {
		this.idUserExt = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getIdUserExt() {
		return idUserExt;
	}

	public void setIdUserExt(String idUserExt) {
		this.idUserExt = idUserExt;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
