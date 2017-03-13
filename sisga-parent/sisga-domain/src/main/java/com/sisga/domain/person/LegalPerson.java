
package com.sisga.domain.person;

public abstract class LegalPerson extends Person {
	protected String cnpj;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	}
