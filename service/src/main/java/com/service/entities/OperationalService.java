package com.service.entities;

import com.service.entities.dto.OperationalRequestDto;
import com.service.entities.dto.OperationalResponseDto;
import com.service.entities.dto.exception.UserAccountNotFoundException;

public interface OperationalService {
	
	void createAcount(OperationalRequestDto operationData) throws UserAccountNotFoundException;
	
	String withDrawal(OperationalRequestDto operationData) throws UserAccountNotFoundException;
	
	void deposit(OperationalRequestDto operationData) throws UserAccountNotFoundException;
	
	OperationalResponseDto extractTransaction(String idExt);

}
