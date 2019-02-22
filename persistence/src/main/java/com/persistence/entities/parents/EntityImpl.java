package com.persistence.entities.parents;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EntityImpl implements IEntity<Long, Date, String> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "CREATED_NAME_BY")
	private String createdNameBy;

	@Column(name = "MODIFIED_NAME_BY")
	private String modifiedNameBy;

	@Column(name = "CREATION_DATE", insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "MODIFICATION_DATE", insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;

	public EntityImpl() {
	}

	public EntityImpl(final String createdNameBy, final String modifiedNameBy, final Date modificationDate) {
		this.createdNameBy = createdNameBy;
		this.modifiedNameBy = modifiedNameBy;
		this.modificationDate = modificationDate;
	}

	public EntityImpl(final String modifiedNameBy) {
		this(null, modifiedNameBy, null);
	}

	public Long getId() {
		return id;
	}

	@Override
	public void setModificationDate(Date currentDate) {
		modificationDate = currentDate;
	}

	@Override
	public void setModifiedNameBy(String name) {
		modifiedNameBy = name;
	}

	@Override
	public Date getModificationDate() {
		return modificationDate;
	}

	@Override
	public String getModifiedNameBy() {
		return modifiedNameBy;
	}

	@Override
	public Date getCreationDate() {
		return creationDate;
	}

	@Override
	public String getCreatedNameBy() {
		return createdNameBy;
	}

}
