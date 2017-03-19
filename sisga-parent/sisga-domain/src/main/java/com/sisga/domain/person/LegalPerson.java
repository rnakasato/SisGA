
package com.sisga.domain.person;

/**
 * 
 * @author Sergio Massao Umiji
 *         10 de mar de 2017
 */

public abstract class LegalPerson extends Person {
	
	protected String corporateName;
	
	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	protected String cnpj;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	}
