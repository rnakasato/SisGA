package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.customer.CustomerOperation;
import com.sisga.domain.customer.CustomerStatus;

/**
 * 
 * @author Sergio Massao Umiji
 *         12 de mar de 2017
 */
public class CustomerStatusDAO extends DomainSpecificEntityDAO < CustomerStatus > {

	@Override
	public List < CustomerStatus > find( CustomerStatus entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < CustomerStatus > findAll() throws Exception {
		List < CustomerStatus > OperationList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM CustomerStatus " );

			Query query = session.createQuery( jpql.toString() );

			OperationList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return OperationList;

	}

}