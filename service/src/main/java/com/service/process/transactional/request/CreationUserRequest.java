package com.service.process.transactional.request;

public class CreationUserRequest {

	protected String firstName;

	protected String lastName;

	protected String modifiedBy;
	
	public CreationUserRequest() {
	}

	public CreationUserRequest(String firstName, String lastName, String modifiedBy) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
