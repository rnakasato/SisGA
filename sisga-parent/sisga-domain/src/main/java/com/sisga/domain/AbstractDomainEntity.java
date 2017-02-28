package com.sisga.domain;

import java.io.Serializable;
import java.util.Date;

public class AbstractDomainEntity implements IEntity, Serializable {
	private Long id;
	private String description;
	private Date insertDate;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate( Date insertDate ) {
		this.insertDate = insertDate;
	}

}
