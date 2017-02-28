package com.sisga.core;

import com.sisga.domain.DomainSpecificEntity;

public interface IDomainSpecificEntityDAO < T extends DomainSpecificEntity > extends IDAO < T > {
	public T findByCode( T entity );
}
