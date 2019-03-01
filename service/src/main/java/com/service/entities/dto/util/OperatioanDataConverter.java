package com.service.entities.dto.util;

public final class OperatioanDataConverter {

//	public static RecordEntity getEntity(OperationalRequestDto dto) {
//		final AccountEntity account = AccountConverter.getEntity(dto.getAccount());
//		return new RecordEntity(dto.getAmount(), dto.getBalance(), dto.getTransnationalType(), account);
//	}
//	
//	
//
//	public static AccountDto getDto(AccountEntity entity) {
//
//		final CustomerEntity customerEntity = entity.getCustomer();
//		final CustomerDto customerDto = customerEntity != null ? new CustomerDto(customerEntity.getFirstName(),
//				customerEntity.getLastName(), customerEntity.getEmail(), customerEntity.getCreatedNameBy()) : null;
//
//		List<OperationalResponseDto> recordDtos = new ArrayList<OperationalResponseDto>();
//
//		final List<RecordEntity> recordEntities = entity.getRecords();
//		if (recordEntities != null && !recordEntities.isEmpty()) {
//			recordEntities.forEach(record -> recordDtos
//					.add(new OperationalResponseDto(record.getAmount(), record.getBalance(), record.getTransnationalType())));
//		}
//
//		return new AccountDto(customerDto, entity.getBalance(), entity.getCurrency(), recordDtos,
//				entity.getModifiedNameBy());
//	}

}
