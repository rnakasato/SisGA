package com.sisga.core;

import java.util.List;

import org.hibernate.Session;

import com.sisga.domain.AbstractDomainEntity;

public interface IDAO < T extends AbstractDomainEntity > {
	public void save( T entity ) throws Exception;

	public void delete( T entity ) throws Exception;

	public void update( T entity ) throws Exception;

	public T findById( T entity ) throws Exception;

	public List < T > find( T entity ) throws Exception;

	public List < T > findAll() throws Exception;

	public void setSession( Session session );

}
