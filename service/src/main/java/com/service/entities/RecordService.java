package com.service.entities;

import java.util.List;

import com.base.service.IService;
import com.persistence.entities.impl.RecordEntity;
import com.service.entities.dto.RecordDto;

public interface RecordService extends IService<RecordEntity, RecordDto> {
	
	List<RecordDto> findByIdAccountExt(final String idAccount);

}
