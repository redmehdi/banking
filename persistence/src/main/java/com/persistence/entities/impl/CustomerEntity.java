// tag::sample[]
package com.persistence.entities.impl;

import static java.util.Objects.requireNonNull;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.base.persistence.BaseEntity;
import com.base.persistence.IEntity;

/**
 * @author RMehdi
 *
 */
@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity implements IEntity<Long, String, Date, String> {

	private static final long serialVersionUID = 1L;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private AccountEntity account;

	@SuppressWarnings("unused")
	private CustomerEntity() {
	}

	/**
	 * Constructor for new registration
	 * 
	 * @param createdNameBy
	 * @param modifiedNameBy
	 * @param firstName
	 * @param lastName
	 */
	public CustomerEntity(final String createdNameBy, final String modifiedNameBy, final String firstName,
			final String lastName) {
		super(createdNameBy, modifiedNameBy);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public CustomerEntity(final String modifiedNameBy, final String firstName, final String lastName) {
		super(modifiedNameBy);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public void addRecord(RecordEntity recordEntity) {
		requireNonNull(account, "cannot add record without having an account bank");
		this.account.addRecored(recordEntity);
	}

	@Override
	public String toString() {
		return String.format("CustomerEntity [ firstName=%s, lastName=%s, accounts=%s]", firstName, lastName, account);
	}

}
