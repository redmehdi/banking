package com.service.entities.dto;

import java.math.BigDecimal;
import java.util.List;

import com.base.dto.IDto;

public class AccountDto implements IDto {

	private static final long serialVersionUID = 1L;

	private String id;

	private BigDecimal balance;

	private String currency;

	private String email;

	private String changedBy;

	private List<RecordDto> dtos;

	private RecordDto record;

	public AccountDto(String id, BigDecimal balance, String currency, String email, String changedBy) {
		this.id = id;
		this.balance = balance;
		this.currency = currency;
		this.email = email;
		this.changedBy = changedBy;
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

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RecordDto getRecord() {
		return record;
	}

	public void setRecord(RecordDto record) {
		this.record = record;
	}

	public List<RecordDto> getDtos() {
		return dtos;
	}

	public void setDtos(List<RecordDto> dtos) {
		this.dtos = dtos;
	}

	@Override
	public String toString() {
		return String.format("AccountDto [id=%s, balance=%s, currency=%s, email=%s, changedBy=%s, record=%s]", id,
				balance, currency, email, changedBy, record);
	}

}
