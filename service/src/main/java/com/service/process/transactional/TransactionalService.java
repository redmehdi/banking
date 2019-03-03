package com.service.process.transactional;

import com.service.entities.exception.UserAccountNotFoundException;
import com.service.process.transactional.request.CreationAccountRequest;
import com.service.process.transactional.request.CreationUserAndAccountRequest;
import com.service.process.transactional.request.CreationUserRequest;
import com.service.process.transactional.request.DepositRequest;
import com.service.process.transactional.request.WithdrawalRequest;
import com.service.process.transactional.response.extractMovementResponse;

public interface TransactionalService {
	
	void createUser(CreationUserRequest request);
	
	void createUserAndAccount(CreationUserAndAccountRequest request);
	
	void createAcount(CreationAccountRequest r) throws UserAccountNotFoundException;
	
	String withDrawal(WithdrawalRequest w) throws UserAccountNotFoundException;
	
	void deposit(DepositRequest r) throws UserAccountNotFoundException;
	
	extractMovementResponse extractTransaction(String idExt) throws UserAccountNotFoundException;

}
