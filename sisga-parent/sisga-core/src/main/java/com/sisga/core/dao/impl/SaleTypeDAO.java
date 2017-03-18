package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.product.Product;
import com.sisga.domain.product.SaleType;

/**
 * 
 * @author Rafael Hikaru Nakasato
 * 7 de mar de 2017
 */
public class SaleTypeDAO extends DomainSpecificEntityDAO < SaleType >{

	@Override
	public List < SaleType > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < SaleType > findAll() throws Exception {
		List < SaleType > saleTypeList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM SaleType " );

			Query query = session.createQuery( jpql.toString() );

			saleTypeList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return saleTypeList;
	}

}
