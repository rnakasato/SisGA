package com.sisga.domain;

import java.io.Serializable;
import java.util.Calendar;

public class AbstractDomainEntity implements IEntity, Serializable {
	private Long id;
	private String description;
	private Calendar insertDate;
	private Calendar updateDate;

	// Para exclusão lógica
	private Boolean active;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId( Long id ) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription( String description ) {
		this.description = description;
	}

	/**
	 * @return the insertDate
	 */
	public Calendar getInsertDate() {
		return insertDate;
	}

	/**
	 * @param insertDate
	 *            the insertDate to set
	 */
	public void setInsertDate( Calendar insertDate ) {
		this.insertDate = insertDate;
	}

	/**
	 * @return the updateDate
	 */
	public Calendar getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate( Calendar updateDate ) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive( Boolean active ) {
		this.active = active;
	}

}
