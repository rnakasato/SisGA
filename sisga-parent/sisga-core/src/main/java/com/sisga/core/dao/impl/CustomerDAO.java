package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.customer.Customer;

/**
 * 
 * @author Sergio Massao Umiji 7 de mar de 2017
 */
public class CustomerDAO extends DomainSpecificEntityDAO < Customer > {

	@Override
	public List < Customer > find( Customer cliente ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < Customer > findAll() throws Exception {
		List < Customer > customerList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM Customer " );

			Query query = session.createQuery( jpql.toString() );

			customerList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return customerList;
	}

}
