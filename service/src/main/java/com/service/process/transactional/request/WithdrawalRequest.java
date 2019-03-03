package com.service.process.transactional.request;

public class WithdrawalRequest {

	private String idUserExt;

	private String requestAmount;

	private String changedBy;

	private String country;

	private String firstName;

	private String LastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getIdUserExt() {
		return idUserExt;
	}

	public void setIdUserExt(String idUserExt) {
		this.idUserExt = idUserExt;
	}

	public String getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(String requestAmount) {
		this.requestAmount = requestAmount;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
