package com.service.entities;

import com.service.entities.dto.AccountDto;

public interface AccountService {
	
	void addAccount(AccountDto account);
	
	AccountDto get(Long id);
	
	void remove(Long id);

}
