package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.product.Product;

/**
 * 
 * @author Rafael Hikaru Nakasato 7 de mar de 2017
 */
public class ProductDAO extends DomainSpecificEntityDAO < Product > {

	@Override
	public List < Product > find( Product produto ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < Product > findAll() throws Exception {
		List < Product > productList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM Product " );

			Query query = session.createQuery( jpql.toString() );

			productList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return productList;
	}

}
