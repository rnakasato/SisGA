package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.product.StockType;

public class StockTypeDAO extends DomainSpecificEntityDAO < StockType > {

	@Override
	public List < StockType > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < StockType > findAll() throws Exception {
		List < StockType > stockTypeList = null;

		StringBuilder jpql = new StringBuilder();
		jpql.append( " FROM StockType " );

		Query query = session.createQuery( jpql.toString() );

		stockTypeList = query.getResultList();

		return stockTypeList;

	}

}
