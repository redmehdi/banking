package com.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.service.process.transactional.request.CreationUserAndAccountRequest;
import com.service.process.transactional.request.CreationUserRequest;
import com.service.process.transactional.request.DepositRequest;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testRestCreatingNewUser() throws Exception {
		CreationUserRequest dtoRequest = new CreationUserRequest();
		dtoRequest.setLastName("mehdi");
		dtoRequest.setFirstName("sadasd");
		dtoRequest.setModifiedBy("RESTTEST");

		Gson gson = new Gson();

		String json = gson.toJson(dtoRequest);
		this.mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
				.andExpect(status().isCreated());
	}
	
	@Test
	public void testRestCreatingNewUserWithAccount() throws Exception {
		CreationUserAndAccountRequest dtoRequest = new CreationUserAndAccountRequest();
		dtoRequest.setLastName("mehdi");
		dtoRequest.setFirstName("sadasd");
		dtoRequest.setModifiedBy("RESTTEST");
		dtoRequest.setBalance("654654654");
		dtoRequest.setCurrency("USD");
		dtoRequest.setEmail("redouane@world.com");

		Gson gson = new Gson();

		String json = gson.toJson(dtoRequest);
		this.mockMvc.perform(post("/addUserAccount").contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
				.andExpect(status().isCreated());
	}
	
	@Test
	public void testRestCreateUserAndDeposit() throws Exception {
		CreationUserAndAccountRequest dtoRequest = new CreationUserAndAccountRequest();
		dtoRequest.setLastName("mehdi");
		dtoRequest.setFirstName("redouane");
		dtoRequest.setModifiedBy("RESTTEST");
		dtoRequest.setBalance("654654654");
		dtoRequest.setCurrency("USD");
		dtoRequest.setEmail("email1@world.com");

		Gson gson = new Gson();

		String json = gson.toJson(dtoRequest);
		this.mockMvc.perform(post("/addUserAccount").contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
				.andExpect(status().isCreated());
		
		
		DepositRequest depositRequest = new DepositRequest();
		depositRequest.setFirstName("redouane");
		depositRequest.setLastName("mehdi");
		depositRequest.setAmount("100009");
		depositRequest.setChangedBy("TESTREST");
		depositRequest.setIdUser(null);
		
		json = gson.toJson(depositRequest);
		this.mockMvc.perform(post("/deposit").contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
		.andExpect(status().isCreated());
		
	}
	
}
