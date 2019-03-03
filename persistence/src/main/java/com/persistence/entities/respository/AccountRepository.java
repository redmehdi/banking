package com.persistence.entities.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.base.repository.IRepository;
import com.persistence.entities.impl.AccountEntity;
import com.persistence.entities.impl.RecordEntity;

public interface AccountRepository extends IRepository<AccountEntity, Long> {

	List<AccountEntity> findByEmail(String email);
	
}
