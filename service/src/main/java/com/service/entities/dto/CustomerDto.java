package com.service.entities.dto;

import com.base.dto.IDto;

public class CustomerDto implements IDto {

	private static final long serialVersionUID = 1L;

	private String id;

	private String firstName;

	private String lastName;

	private String modifiedBy;
	
	private AccountDto accountDto;

	public CustomerDto(final String id, final String firstName, final String lastName, final String modifiedBy) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.modifiedBy = modifiedBy;
	}

	public CustomerDto(String firstName, String lastName, String modifiedBy) {
		this(null, firstName, lastName, modifiedBy);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public AccountDto getAccountDto() {
		return accountDto;
	}

	public void setAccountDto(AccountDto accountDto) {
		this.accountDto = accountDto;
	}

	@Override
	public String toString() {
		return String.format("CustomerDto [id=%s, firstName=%s, lastName=%s, modifiedBy=%s]", id, firstName, lastName,
				modifiedBy);
	}

}
