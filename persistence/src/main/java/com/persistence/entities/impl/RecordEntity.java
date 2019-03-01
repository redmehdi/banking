package com.persistence.entities.impl;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.persistence.entities.parents.BaseEntity;

/**
 * @author RMehdi
 *
 */
@Entity
@Table(name = "record")
public class RecordEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private BigDecimal amount;

	@Column(nullable = false)
	private BigDecimal balance;

	@Column(name = "TRANSNATIONAL_TYPE", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TransnationalType transnationalType;

	@JoinColumn(name = "account_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private AccountEntity account;

	@SuppressWarnings("unused")
	private RecordEntity() {
	}

	public RecordEntity(final String createdNameBy, final String modifiedNameBy, final BigDecimal amount,
			final BigDecimal balance, final TransnationalType transnationalType) {
		super(createdNameBy, modifiedNameBy);
		this.amount = amount;
		this.balance = balance;
		this.transnationalType = transnationalType;
	}

	public RecordEntity(final String modifiedNameBy, final BigDecimal amount, final BigDecimal balance,
			final TransnationalType transnationalType, final AccountEntity account) {
		super(modifiedNameBy);
		this.amount = amount;
		this.balance = balance;
		this.transnationalType = transnationalType;
		this.account = account;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public TransnationalType getTransnationalType() {
		return transnationalType;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return String.format("RecordEntity [amount=%s, balance=%s, transnationalType=%s, account=%s]", amount, balance,
				transnationalType, account);
	}

}
