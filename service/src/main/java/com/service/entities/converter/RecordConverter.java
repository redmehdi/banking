package com.service.entities.converter;

import java.math.BigDecimal;

import com.base.converter.BaseConverter;
import com.persistence.entities.impl.RecordEntity;
import com.persistence.entities.impl.TransnationalType;
import com.service.entities.dto.RecordDto;
import com.service.entities.dto.TransnationalTypeDto;

public class RecordConverter extends BaseConverter<RecordEntity, RecordDto> {

	@Override
	public RecordDto getDto(RecordEntity e) {
		TransnationalTypeDto transnationalType = TransnationalTypeDto.valueOf(e.getTransnationalType().toString());
		return new RecordDto(e.getIdExt(), e.getAmount(), e.getBalance(), transnationalType, e.getModifiedNameBy());
	}

	@Override
	public RecordEntity getEntity(RecordDto t) {
		final TransnationalType transnationalType = TransnationalType.valueOf(t.getTypeDto().toString());
		final BigDecimal amount = t.getAmount();
		final BigDecimal balance = t.getBalance();
		final String modifiedNameBy = t.getChangedBy();
		return new RecordEntity(modifiedNameBy, modifiedNameBy, amount, balance, transnationalType);
	}

}
