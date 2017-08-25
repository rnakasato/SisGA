package com.sisga.domain.address;

import com.sisga.domain.DomainSpecificEntity;

/**
 * 
 * @author Sergio Massao Umiji
 *         10 de mar de 2017
 */

public class State extends DomainSpecificEntity {
	private String name;
	private String uf;

	public String getUf() {
		return uf;
	}

	public void setUf( String uf ) {
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

}
