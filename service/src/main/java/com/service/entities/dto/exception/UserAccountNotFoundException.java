package com.service.entities.dto.exception;

public class UserAccountNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserAccountNotFoundException(String msg) {
		super(msg);
	}

}
