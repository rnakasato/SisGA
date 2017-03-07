package com.sisga.domain.customer;

public class Customer extends LegalPerson {
	
	private boolean ativo;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
