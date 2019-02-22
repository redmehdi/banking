package com.persistence.entities.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.persistence.entities.parents.EntityImpl;

/**
 * @author RMehdi
 *
 */
@Entity
@Table(name = "record")
public class RecordEntity extends EntityImpl {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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

	public RecordEntity() {
	}

	public RecordEntity(BigDecimal amount, BigDecimal balance, TransnationalType transnationalType,
			String createdNameBy, String modifiedNameBy) {
		super(createdNameBy, modifiedNameBy, new Date());
		this.amount = amount;
		this.balance = balance;
		this.transnationalType = transnationalType;
	}

	public RecordEntity(BigDecimal amount, BigDecimal balance, TransnationalType transnationalType,
			AccountEntity account) {
		this.amount = amount;
		this.balance = balance;
		this.transnationalType = transnationalType;
		this.account = account;
	}

	@Override
	public Long getId() {
		return id;
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
		return String.format("RecordEntity [id=%s, amount=%s, balance=%s, transnationalType=%s, account=%s]", id,
				amount, balance, transnationalType, account);
	}

}
