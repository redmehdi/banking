package com.service.entities.dto.util;

import static org.apache.commons.lang3.Validate.matchesPattern;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.validator.routines.EmailValidator;

import com.service.entities.dto.exception.ValidationException;

public final class UtilProcessService {

	private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
	private static final String PHONE_REGEX = "(\\+34|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}";

	public static Long stringToLong(final String number) {
		Long num = null;
		try {
			num = Long.parseLong(number);
		} catch (NumberFormatException e) {
		}
		return num;
	}

	public static String validateEmail(final String email) throws ValidationException {
		matchesPattern(email, EMAIL_REGEX, "invalid email");
		EmailValidator validator = EmailValidator.getInstance();
		if (email == null || email.equals("") || !validator.isValid(email)) {
			throw new ValidationException("Please enter the email correctly");
		}
		return email;
	}
	
	public static String validatePhone(final String phone) throws ValidationException {
		matchesPattern(phone, PHONE_REGEX, "invalid phone number");
		if (phone == null || phone.equals("")) {
			throw new ValidationException("Please enter the phone number correctly");
		}
		return phone;
	}

	/**
	 * @param date
	 * @return {@link Date}
	 * @throws ParseException
	 */
	public final static Date stringToDate(final String date) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(date);
	}

}
