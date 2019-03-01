package com.persistence.entities.impl;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.persistence.entities.parents.BaseEntity;

/**
 * @author RMehdi
 *
 */
@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "CUSTOMER_ID")
	@OneToOne(fetch = LAZY)
	private CustomerEntity customer;

	@Column(nullable = false)
	private BigDecimal balance;

	@Column(nullable = false)
	private String currency;

	@Column(unique = true)
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "account")
	private List<RecordEntity> records;

	@SuppressWarnings("unused")
	private AccountEntity() {
	}

	public AccountEntity(final String createdNameBy, final String modifiedNameBy, final BigDecimal balance,
			final String currency, final String email) {
		super(createdNameBy, modifiedNameBy);
		this.balance = balance;
		this.currency = currency;
		this.email = email;
	}

	public AccountEntity(final String modifiedNameBy, final BigDecimal balance, final String currency,
			final String email) {
		super(modifiedNameBy);
		this.balance = balance;
		this.currency = currency;
		this.email = email;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public String getCurrency() {
		return currency;
	}

	public List<RecordEntity> getRecords() {
		return records;
	}

	public void setRecords(List<RecordEntity> records) {
		this.records = records;
	}

	public void addRecored(final RecordEntity record) {
		if (records == null)
			records = new ArrayList<>();
		records.add(record);
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return String.format("AccountEntity [customer=%s, balance=%s, currency=%s, email=%s, records=%s]", customer,
				balance, currency, email, records);
	}

}
