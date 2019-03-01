package com.persistence.entities.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.persistence.entities.impl.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

	List<AccountEntity> findByEmail(String email);

}
