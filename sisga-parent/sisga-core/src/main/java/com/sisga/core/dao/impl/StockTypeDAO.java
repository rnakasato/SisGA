package com.sisga.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.product.StockType;
import com.sisga.domain.product.filter.StockTypeFilter;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         19 de mar de 2017
 */
public class StockTypeDAO extends DomainSpecificEntityDAO < StockType > {

	public StockTypeDAO() {
		super( StockType.class );
	}

	@Override
	public List < StockType > find( AbstractDomainEntity entity ) throws Exception {
		// O find foi feito para retornar somente um
		// irá buscar o estoque pelo código e adicionar apenas um item na
		// lista
		StockTypeFilter filter = ( StockTypeFilter ) entity;
		StockType stockType = new StockType();
		stockType.setCode( filter.getCode() );

		List < StockType > stockTypeList = new ArrayList<>();

		stockTypeList.add( findByCode( stockType ) );
		return stockTypeList;
	}

}
