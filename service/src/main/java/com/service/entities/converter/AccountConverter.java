package com.service.entities.converter;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.base.converter.BaseConverter;
import com.persistence.entities.impl.AccountEntity;
import com.persistence.entities.impl.RecordEntity;
import com.service.entities.dto.AccountDto;
import com.service.entities.dto.RecordDto;

@ComponentScan({ "com.*" })
@Component
public final class AccountConverter extends BaseConverter<AccountEntity, AccountDto> {

	private RecordConverter recordConverter;

	@Override
	public AccountDto getDto(AccountEntity entity) {
		recordConverter = new RecordConverter();
		AccountDto accountDto = new AccountDto(entity.getIdExt(), entity.getBalance(), entity.getCurrency(), entity.getEmail(),
				entity.getModifiedNameBy());
		final List<RecordEntity> records = entity.getRecords();
		if (records != null) {
			accountDto.setDtos(recordConverter.getDtos(records));
		}
		return accountDto;
	}

	@Override
	public AccountEntity getEntity(AccountDto dto) {
		if (dto == null)
			return null;

		final String changedBy = dto.getChangedBy();
		final BigDecimal balance = dto.getBalance();
		final String currency = dto.getCurrency();
		final String email = dto.getEmail();
		final RecordDto record = dto.getRecord();

		// for new registration
		if (dto.getId() == null) {
			final AccountEntity accountEntity = new AccountEntity(changedBy, changedBy, balance, currency, email);
			getRecordEntity(record, accountEntity);
			return accountEntity;
		}
		// for update
		final AccountEntity accountEntity = new AccountEntity(changedBy, balance, currency, email);
		getRecordEntity(record, accountEntity);
		return accountEntity;
	}

	private void getRecordEntity(final RecordDto record, final AccountEntity accountEntity) {
		recordConverter = new RecordConverter();
		if (record != null)
			accountEntity.addRecored(recordConverter.getEntity(record));
	}

}
