package com.service.process.transactional.request;

public class CreationUserAndAccountRequest extends CreationUserRequest {

	private String balance;

	private String currency;

	private String email;
	
	public CreationUserAndAccountRequest() {}

	public CreationUserAndAccountRequest(String firstName, String lastName, String modifiedBy, String balance,
			String currency, String email) {
		super(firstName, lastName, modifiedBy);
		this.balance = balance;
		this.currency = currency;
		this.email = email;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
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

}
