package com.sisga.domain.customer;

import com.sisga.domain.person.LegalPerson;

public class Customer extends LegalPerson {
	
	private boolean ativo;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
