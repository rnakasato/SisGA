package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.sisga.core.IDAO;
import com.sisga.domain.AbstractDomainEntity;

public abstract class AbstractDAO < T extends AbstractDomainEntity > implements IDAO < T > {
	protected Class < T > entityClass;

	protected Session session;

	public AbstractDAO( Class < T > entityClass ) {
		this.entityClass = entityClass;
	}

	@Override
	public void save( T entity ) throws Exception {
		session.save( entity );
	}

	@SuppressWarnings( { "unchecked", "rawtypes" } )
	@Override
	public T findById( T entity ) throws Exception {
		T result = null;

		Class clazz = entity.getClass();
		result = ( T ) session.find( clazz, entity.getId() );
		return result;
	}

	@Override
	public List < T > findAll() throws Exception {
		List < T > entityList = null;

		StringBuilder jpql = new StringBuilder();
		jpql.append( " FROM  " );
		jpql.append( entityClass.getName() );
		// Não faz filtro automatico de "active" porque nem todas as classes são
		// mapeadas com esse atributo
		// TODO avaliar se dever ser adicionado nos mapeamentos ou se mantem
		// dessa forma

		Query query = session.createQuery( jpql.toString() );

		entityList = query.getResultList();

		return entityList;

	}

	@Override
	public void delete( T entity ) throws Exception {
		session.delete( entity );
	}

	@Override
	public void update( T entity ) throws Exception {
		session.update( entity );
	}

	public Session getSession() {
		return session;
	}

	public void setSession( Session session ) {
		this.session = session;
	}
}
