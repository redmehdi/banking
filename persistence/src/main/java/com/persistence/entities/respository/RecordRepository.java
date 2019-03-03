package com.persistence.entities.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.base.repository.IRepository;
import com.persistence.entities.impl.RecordEntity;

public interface RecordRepository extends IRepository<RecordEntity, Long> {

	@Query("select u from RecordEntity u INNER JOIN FETCH u.account a where a.email = :email")
	List<RecordEntity> findByEmail(@Param("email") String email);
	
	@Query("select u from RecordEntity u INNER JOIN FETCH u.account a where a.idExt = :idAccountExt")
	List<RecordEntity> findByIdAccountExt(@Param("idAccountExt") String idAccountExt);

}
