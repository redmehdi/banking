package com.service.entities;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.persistence.entities.respository.AccountRepository;
import com.service.entities.dto.AccountDto;
import com.service.entities.dto.util.AccountConverter;

@Component
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional
	public void addAccount(AccountDto dto) {
		accountRepository.save(AccountConverter.getEntity(dto));
	}

	public AccountDto get(Long id) {
		return AccountConverter.getDto(accountRepository.findById(id).get());
	}

	@Transactional
	public void remove(Long id) {
		accountRepository.deleteById(id);
	}

}
