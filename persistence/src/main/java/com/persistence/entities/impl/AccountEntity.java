package com.persistence.entities.impl;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.persistence.entities.parents.EntityImpl;

/**
 * @author RMehdi
 *
 */
@Entity
@Table(name = "account")
public class AccountEntity extends EntityImpl {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

	@JoinColumn(name = "CUSTOMER_ID")
	@OneToOne(fetch = LAZY)
	private CustomerEntity customer;

	@Column(nullable = false)
	private BigDecimal balance;

	@Column(nullable = false)
	private String currency;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "account")
	private List<RecordEntity> records;

	public AccountEntity() {
	}

	public AccountEntity(String createdNameBy, String modifiedNameBy, BigDecimal balance,
			String currency) {
		super(createdNameBy, modifiedNameBy, null);
		this.balance = balance;
		this.currency = currency;
	}

	public AccountEntity(String modifiedNameBy, BigDecimal balance, String currency) {
		this(null, modifiedNameBy, balance, currency);
	}

	@Override
	public Long getId() {
		return id;
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

//	@Override
//	public String toString() {
//		return String.format("AccountEntity [id=%s, customer=%s, balance=%s, currency=%s, records=%s]", id, customer,
//				balance, currency, records);
//	}

}
