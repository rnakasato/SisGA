package com.sisga.domain.filter.impl;

import com.sisga.domain.DomainSpecificEntity;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         10 de mar de 2017
 * @param <T>
 */
public abstract class DomainSpecificEntityFilter < T extends DomainSpecificEntity > extends Filter < T > {
	private String code;
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode( String code ) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

}
