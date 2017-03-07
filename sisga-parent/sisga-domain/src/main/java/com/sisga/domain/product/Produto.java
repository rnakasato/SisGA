package com.sisga.domain.product;

import com.sisga.domain.AbstractDomainEntity;

public class Produto extends AbstractDomainEntity {
	private Double valorBase;
	private String caminhoFoto;
	private TipoVenda tipoVenda;
	private TipoProducao tipoProducao;

	public Double getValorBase() {
		return valorBase;
	}

	public void setValorBase( Double valorBase ) {
		this.valorBase = valorBase;
	}

	public String getCaminhoFoto() {
		return caminhoFoto;
	}

	public void setCaminhoFoto( String caminhoFoto ) {
		this.caminhoFoto = caminhoFoto;
	}

	public TipoVenda getTipoVenda() {
		return tipoVenda;
	}

	public void setTipoVenda( TipoVenda tipoVenda ) {
		this.tipoVenda = tipoVenda;
	}

	public TipoProducao getTipoProducao() {
		return tipoProducao;
	}

	public void setTipoProducao( TipoProducao tipoProducao ) {
		this.tipoProducao = tipoProducao;
	}

}
