package com.persistence.entities.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.base.repository.IRepository;
import com.persistence.entities.impl.CustomerEntity;

@Repository
public interface CustomerRepository extends IRepository<CustomerEntity, Long>{
	
	List<CustomerEntity> findByLastName(String lastName);

	@Query("select u from CustomerEntity u where u.firstName = :firstName and u.lastName = :lastName")
	List<CustomerEntity> findByFirstLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
