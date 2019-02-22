package com.persistence.entities.parents;

import java.io.Serializable;

public interface IEntity<I1,I2,I3> extends Serializable {
	
	I1 getId();
	
	I2 getModificationDate();
	void setModificationDate(I2 currentDate);
	
	I3 getModifiedNameBy();
	void setModifiedNameBy(I3 name);
	
	I2 getCreationDate();
	I3 getCreatedNameBy();
	
}
