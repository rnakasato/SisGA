package com.sisga.core.dao.impl;

import javax.persistence.Query;

import com.sisga.core.IDomainSpecificEntityDAO;
import com.sisga.domain.DomainSpecificEntity;

public abstract class DomainSpecificEntityDAO < T extends DomainSpecificEntity > extends AbstractDAO < T >
		implements IDomainSpecificEntityDAO < T > {

	public DomainSpecificEntityDAO( Class < T > entityClass ) {
		super( entityClass );
	}

	@Override
	public T findByCode( T entity ) {
		T result = null;

		StringBuilder jpql = new StringBuilder();
		jpql.append( " FROM " ).append( entity.getClass().getName() ).append( " d " );
		jpql.append( " WHERE d.code = :code" );

		Query query = session.createQuery( jpql.toString() );
		query.setParameter( "code", entity.getCode() );
		result = ( T ) query.getSingleResult();

		return result;
	}

}
