package com.service.entities.dto;

import java.math.BigDecimal;

public class OperationalRequestDto {

	private String idUserExt;

	private String email;

	private BigDecimal amount;

	private BigDecimal balance;

	private String changedBy;

	private String currency;

	public OperationalRequestDto(String idUserExt, String email, BigDecimal amount, BigDecimal balance,
			String changedBy, String currency) {
		super();
		this.idUserExt = idUserExt;
		this.email = email;
		this.amount = amount;
		this.balance = balance;
		this.changedBy = changedBy;
		this.currency = currency;
	}

	public String getIdUserExt() {
		return idUserExt;
	}

	public void setIdUserExt(String idUserExt) {
		this.idUserExt = idUserExt;
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
