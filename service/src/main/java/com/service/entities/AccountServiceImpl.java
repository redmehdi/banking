package com.service.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.converter.BaseConverter;
import com.base.service.BaseService;
import com.persistence.entities.impl.AccountEntity;
import com.persistence.entities.respository.AccountRepository;
import com.service.entities.converter.AccountConverter;
import com.service.entities.dto.AccountDto;

@Service
public class AccountServiceImpl extends BaseService<AccountEntity, AccountDto, AccountRepository>
		implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	protected BaseConverter<AccountEntity, AccountDto> getConverter() {
		return new AccountConverter();
	}

	@Override
	public List<AccountDto> findByEmail(String email) {
		return getConverter().getDtos(accountRepository.findByEmail(email));
	}

}
