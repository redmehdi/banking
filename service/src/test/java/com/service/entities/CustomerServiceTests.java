package com.service.entities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.entities.dto.CustomerDto;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerServiceTests {
	
    @Autowired
    private CustomerService customerService;

    @Test
    public void testFindByLastName() {
    	customerService.addUser(new CustomerDto("red1", "dss","egdj@ddsdsfsdjk.com", "Sys"));

        CustomerDto user = customerService.getUserDto("dss");

//        assertThat(findByLastName).extracting(CustomerEntity::getLastName).containsOnly(customer.getLastName());
    }
}
