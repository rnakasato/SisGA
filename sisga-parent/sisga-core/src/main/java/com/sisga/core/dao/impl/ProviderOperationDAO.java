package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.provider.ProviderOperation;

/**
 * 
 * @author Sergio Massao Umiji 12 de mar de 2017
 */
public class ProviderOperationDAO extends DomainSpecificEntityDAO < ProviderOperation > {

	@Override
	public List < ProviderOperation > find( ProviderOperation entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < ProviderOperation > findAll() throws Exception {
		List < ProviderOperation > operationList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM ProviderOperation " );

			Query query = session.createQuery( jpql.toString() );

			operationList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return operationList;
	}
}
	