package com.sisga.core;

import com.sisga.core.application.Result;
import com.sisga.domain.AbstractDomainEntity;

public interface IFacade < T extends AbstractDomainEntity > {
	public Result < T > save( T entity );

	public Result < T > update( T entity );

	public Result < T > delete( T entity );

	public Result < T > find( T entity );

	public Result < T > findAll( T entity );
}
