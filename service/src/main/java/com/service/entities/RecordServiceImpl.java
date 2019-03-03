package com.service.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.converter.BaseConverter;
import com.base.service.BaseService;
import com.persistence.entities.impl.RecordEntity;
import com.persistence.entities.respository.RecordRepository;
import com.service.entities.converter.RecordConverter;
import com.service.entities.dto.RecordDto;

@Service
public class RecordServiceImpl extends BaseService<RecordEntity, RecordDto, RecordRepository> implements RecordService {

	@Autowired
	private RecordRepository repository;

	@Override
	public List<RecordDto> findByIdAccountExt(String idAccount) {
		final List<RecordEntity> findByEmail = repository.findByIdAccountExt(idAccount);
		if (findByEmail == null || findByEmail.isEmpty())
			return null;
		return getConverter().getDtos(findByEmail);
	}

	@Override
	protected BaseConverter<RecordEntity, RecordDto> getConverter() {
		return new RecordConverter();
	}

}
