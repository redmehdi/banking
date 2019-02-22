package com.service.entities.dto;

public class CustomerDto {

	private String firstName;

	private String lastName;

	private String email;

	private String modifiedBy;

	public CustomerDto(String firstName, String lastName, String email, String modifiedBy) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.modifiedBy = modifiedBy;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return String.format("UserDto [firstName=%s, lastName=%s, email=%s]", firstName, lastName, email);
	}

}
