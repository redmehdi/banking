package com.service.entities;

import java.util.List;

import com.base.service.IService;
import com.persistence.entities.impl.AccountEntity;
import com.service.entities.dto.AccountDto;

public interface AccountService extends IService<AccountEntity, AccountDto> {
	
	List<AccountDto> findByEmail(final String email);

}
