package com.sisga.domain.product;

import com.sisga.domain.AbstractDomainEntity;

public class TipoProducao extends AbstractDomainEntity {
	private TipoUnidade tipoUnidade;

	public TipoUnidade getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade( TipoUnidade tipoUnidade ) {
		this.tipoUnidade = tipoUnidade;
	}

}
