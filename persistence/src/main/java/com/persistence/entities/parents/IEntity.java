package com.persistence.entities.parents;

import java.io.Serializable;

public interface IEntity<I1,I2,I3,I4> extends Serializable {
	
	I1 getId();
	
	I2 getIdExt();
	
	I3 getModificationDate();
	void setModificationDate(I3 currentDate);
	
	I4 getModifiedNameBy();
	void setModifiedNameBy(I4 name);
	
	I3 getCreationDate();
	I4 getCreatedNameBy();
	
}