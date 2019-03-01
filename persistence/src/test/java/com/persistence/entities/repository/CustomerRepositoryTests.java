/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.persistence.entities.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.persistence.entities.impl.AccountEntity;
import com.persistence.entities.impl.CustomerEntity;
import com.persistence.entities.impl.RecordEntity;
import com.persistence.entities.repository.dataset.AccountDataset;
import com.persistence.entities.repository.dataset.CustomerDataset;
import com.persistence.entities.repository.dataset.RecordDataset;
import com.persistence.entities.respository.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CustomerRepository customers;

	@Test
	public void testFindByLastName() {
		CustomerEntity customer1 = CustomerDataset.newCustomers()[0];
		entityManager.persist(customer1);
		List<CustomerEntity> findByLastName = customers.findByLastName(customer1.getLastName());
		assertThat(findByLastName).extracting(CustomerEntity::getLastName).containsOnly(customer1.getLastName());
	}

	@Test
	public void testCreateNewUser() {
		CustomerEntity customer1 = CustomerDataset.newCustomers()[0];
		entityManager.persist(customer1);
		Optional<CustomerEntity> findById = customers.findById(customer1.getId());
		assertThat(findById.get()).extracting(CustomerEntity::getFirstName).containsOnly(customer1.getFirstName());
	}

	@Test
	public void testCreateAccountForUser() {
		CustomerEntity customer1 = CustomerDataset.newCustomers()[0];
		AccountEntity account1 = AccountDataset.newAccounts()[0];
		customer1.setAccount(account1);
		entityManager.persist(customer1);

		List<CustomerEntity> accountUser = customers.findByLastName(customer1.getLastName());

		assertThat(accountUser).extracting(CustomerEntity::getAccount).containsOnly(account1);
	}

	@Test
	public void testCreateUserDesposit() {
		CustomerEntity customer1 = CustomerDataset.newCustomers()[1];
		AccountEntity accountUser = AccountDataset.newAccounts()[1];
		customer1.setAccount(accountUser);
		entityManager.persist(customer1);

		// deposit money
		Optional<CustomerEntity> userCustomer = customers.findById(customer1.getId());
		RecordEntity record = RecordDataset.newRecords()[0];
		CustomerEntity entity = userCustomer.get();
		entity.addRecord(record);

		entityManager.merge(entity);

		assertThat(userCustomer.get().getAccount().getRecords()).extracting(RecordEntity::getAmount)
				.containsOnly(record.getAmount());
	}
//
//	@Test
//	public void testCreateUserWithDrawal() {
//		CustomerEntity customer1 = new CustomerEntity("Redouane", "Redouane", "nameuser1", "lastname1",
//				"nameuser1@sdsad.com");
//		AccountEntity accountFirst = new AccountEntity("redouane", "Redouane", customer1, BigDecimal.valueOf(233424233),
//				"EURO");
//		customer1.setAccount(accountFirst);
//		RecordEntity record = new RecordEntity(BigDecimal.valueOf(874398709L), BigDecimal.valueOf(398423874398709L),
//				TransnationalType.DEPOSIT, "redouane", "redouane");
//		customer1.setAccount(accountFirst);
//		entityManager.persist(customer1);
//		accountFirst.addRecored(record);
//		entityManager.persist(accountFirst);
//
//		List<CustomerEntity> findByLastName = customers.findByLastName(customer1.getLastName());
//
//		assertThat(findByLastName).extracting(CustomerEntity::getLastName).containsOnly(customer1.getLastName());
//	}

}