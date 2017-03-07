package com.sisga.core.business;

import com.sisga.domain.AbstractDomainEntity;

public abstract class Filler < T extends AbstractDomainEntity > extends AbstractStrategy < T > {

	@Override
	public String process( T entity ) {
		return fill( entity );
	}

	public abstract String fill( T entity );
}
