package com.persistence.entities.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.persistence.entities.impl.RecordEntity;

public interface RecordRepository extends CrudRepository<RecordEntity, Long> {
	
	@Query("select u from RecordEntity u INNER JOIN FETCH u.account a where a.email = :email")
	List<RecordEntity> findByEmail(@Param("email") String email);

}
