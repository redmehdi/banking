package com.persistence.entities.respository;

import org.springframework.data.repository.CrudRepository;

import com.persistence.entities.impl.RecordEntity;

public interface RecordRepository extends CrudRepository<RecordEntity, Long> {

}
