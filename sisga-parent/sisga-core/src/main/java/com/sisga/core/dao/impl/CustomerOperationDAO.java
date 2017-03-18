package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.customer.CustomerOperation;

/**
 * 
 * @author Sergio Massao Umiji
 *         12 de mar de 2017
 */
public class CustomerOperationDAO extends DomainSpecificEntityDAO < CustomerOperation > {

	@Override
	public List < CustomerOperation > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < CustomerOperation > findAll() throws Exception {
		List < CustomerOperation > OperationList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM CustomerOperation " );

			Query query = session.createQuery( jpql.toString() );

			OperationList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return OperationList;

	}

}