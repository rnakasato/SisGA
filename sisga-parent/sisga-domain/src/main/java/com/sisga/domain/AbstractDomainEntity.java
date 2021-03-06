package com.sisga.domain;

import java.io.Serializable;
import java.util.Date;

public class AbstractDomainEntity implements IEntity, Serializable {
	private Long id;
	private String description;
	private Date insertDate;
	private Date updateDate;

	// Para exclus�o l�gica
	private Boolean active;

	// Utilizado para facilitar geração de histórico
	private String operationCode;

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

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode( String operationCode ) {
		this.operationCode = operationCode;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate( Date updateDate ) {
		this.updateDate = updateDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive( Boolean active ) {
		this.active = active;
	}

}
