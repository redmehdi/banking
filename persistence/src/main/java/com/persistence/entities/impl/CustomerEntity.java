// tag::sample[]
package com.persistence.entities.impl;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.persistence.entities.parents.EntityImpl;

/**
 * @author RMehdi
 *
 */
@Entity
@Table(name = "customer")
public class CustomerEntity extends EntityImpl {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(unique = true)
	private String email;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private AccountEntity account;

	public CustomerEntity() {
	}

	public CustomerEntity(String createdNameBy, String modifiedNameBy, String firstName, String lastName,
			String email) {
		super(createdNameBy, modifiedNameBy, new Date());
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public CustomerEntity(String modifiedNameBy, String firstName, String lastName, String email) {
		this(null, modifiedNameBy, firstName, lastName, email);
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return String.format("CustomerEntity [id=%s, firstName=%s, lastName=%s, email=%s, accounts=%s]", id, firstName,
				lastName, email, account);
	}

}
