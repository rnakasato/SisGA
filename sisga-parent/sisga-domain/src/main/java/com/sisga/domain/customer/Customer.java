package com.sisga.domain.customer;

public class Customer extends PessoaJuridica {
	
	private boolean ativo;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
