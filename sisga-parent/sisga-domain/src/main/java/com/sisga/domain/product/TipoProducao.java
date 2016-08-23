package com.sisga.domain.product;

import com.sisga.domain.AbstractEntity;

public class TipoProducao extends AbstractEntity {
	private TipoUnidade tipoUnidade;

	public TipoUnidade getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(TipoUnidade tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

}
