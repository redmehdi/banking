package com.service.entities.dto;

import java.math.BigDecimal;

import com.base.dto.IDto;

public class RecordDto implements IDto {

	private static final long serialVersionUID = 1L;

	private String id;

	private BigDecimal amount;

	private BigDecimal balance;

	private TransnationalTypeDto typeDto;

	private String changedBy;

	public RecordDto(String id, BigDecimal amount, BigDecimal balance, TransnationalTypeDto typeDto, String changedBy) {
		this.id = id;
		this.amount = amount;
		this.balance = balance;
		this.typeDto = typeDto;
		this.changedBy = changedBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return String.format("RecordDto [id=%s, amount=%s, balance=%s, typeDto=%s, changedBy=%s]", id, amount, balance,
				typeDto, changedBy);
	}

}
