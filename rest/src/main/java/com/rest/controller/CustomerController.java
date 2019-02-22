package com.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.entities.dto.CustomerDto;

@RestController
public class CustomerController {

	@RequestMapping("/getuser")
	public CustomerDto greeting(@RequestParam(value = "firstname") String firstName,
			@RequestParam(value = "lastname") String lastName, @RequestParam(value = "email") String email) {
		return new CustomerDto(firstName, lastName, email, "test");
	}

}
