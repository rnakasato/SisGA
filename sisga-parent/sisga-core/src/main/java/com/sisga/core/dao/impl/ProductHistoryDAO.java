package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.product.ProductHistory;
import com.sisga.domain.product.filter.ProductHistoryFilter;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         19 de mar de 2017
 */
public class ProductHistoryDAO extends DomainSpecificEntityDAO < ProductHistory > {

	public ProductHistoryDAO() {
		super( ProductHistory.class );
	}

	@Override
	public List < ProductHistory > find( AbstractDomainEntity entity ) throws Exception {
		ProductHistoryFilter filter = ( ProductHistoryFilter ) entity;
		List < ProductHistory > productHistoryList = null;

		StringBuilder jpql = new StringBuilder();

		jpql.append( " SELECT DISTINCT(ph) FROM ProductHistory ph " );
		jpql.append( " LEFT JOIN ph.saleType sat " );
		jpql.append( " LEFT JOIN ph.productionType prt " );
		jpql.append( " LEFT JOIN ph.stockType stk " );
		jpql.append( " LEFT JOIN ph.product p " );
		jpql.append( " WHERE 1=1 " );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			jpql.append( " AND p.code like :productCode " );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			jpql.append( " AND UPPER(p.description) like  :description  " );
		}

		if( filter.getSaleType() != null && StringUtils.isNotEmpty( filter.getSaleType().getCode() ) ) {
			jpql.append( " AND sat.code like :saleType  " );
		}

		if( filter.getStockType() != null && StringUtils.isNotEmpty( filter.getStockType().getCode() ) ) {
			jpql.append( " AND stk.code like :stockType  " );
		}

		if( filter.getProductionType() != null && StringUtils.isNotEmpty( filter.getProductionType().getCode() ) ) {
			jpql.append( " AND prt.code like :productionType  " );
		}

		if( filter.getInsertDate() != null ) {
			jpql.append( " AND ph.insertDate =  :insertDate  " );
		}

		Query query = session.createQuery( jpql.toString() );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			query.setParameter( "productCode", "%" + filter.getCode().toUpperCase() + "%" );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			query.setParameter( "description", "%" + filter.getDescription().toUpperCase() + "%" );
		}

		if( filter.getSaleType() != null && StringUtils.isNotEmpty( filter.getSaleType().getCode() ) ) {
			query.setParameter( "saleType", "%" + filter.getSaleType().getCode().toUpperCase() + "%" );
		}

		if( filter.getStockType() != null && StringUtils.isNotEmpty( filter.getStockType().getCode() ) ) {
			query.setParameter( "stockType", "%" + filter.getStockType().getCode().toUpperCase() + "%" );
		}

		if( filter.getProductionType() != null && StringUtils.isNotEmpty( filter.getProductionType().getCode() ) ) {
			query.setParameter( "productionType", "%" + filter.getProductionType().getCode().toUpperCase() + "%" );
		}

		if( filter.getInsertDate() != null ) {
			query.setParameter( "insertDate", filter.getInsertDate() );
		}

		productHistoryList = query.getResultList();

		return productHistoryList;
	}
}
