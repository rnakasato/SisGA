package com.sisga.core.business;

import com.sisga.domain.AbstractDomainEntity;

public abstract class Validator < T extends AbstractDomainEntity > extends AbstractStrategy < T > {

	@Override
	public String process( T entity ) {
		return validate( entity );
	}

	public abstract String validate( T entity );
}
