
package com.sisga.domain.person;

/**
 * 
 * @author Sergio Massao Umiji
 *         10 de mar de 2017
 */

public abstract class LegalPerson extends Person {
	protected String cnpj;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	}
