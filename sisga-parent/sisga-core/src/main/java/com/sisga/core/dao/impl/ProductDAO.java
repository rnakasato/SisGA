
package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.product.Product;
import com.sisga.domain.product.filter.ProductFilter;

/**
 * 
 * @author Rafael Hikaru Nakasato 7 de mar de 2017
 */
public class ProductDAO extends DomainSpecificEntityDAO < Product > {

	@Override
	public List < Product > find( AbstractDomainEntity entity ) throws Exception {
		ProductFilter filter = ( ProductFilter ) entity;
		List < Product > productList = null;

		StringBuilder jpql = new StringBuilder();

		jpql.append( " SELECT DISTINCT(p) FROM Product p " );
		jpql.append( " LEFT JOIN p.saleType sat " );
		jpql.append( " LEFT JOIN p.productionType prt " );
		jpql.append( " LEFT JOIN p.stockType stk " );
		jpql.append( " WHERE 1=1 " );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			jpql.append( " AND p.code like :productCode " );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			jpql.append( " AND p.description like :description " );
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
			jpql.append( " AND p.insertDate =  :insertDate  " );
		}

		Query query = session.createQuery( jpql.toString() );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			query.setParameter( "productCode", filter.getCode() );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			query.setParameter( "description", filter.getDescription() );
		}

		if( filter.getSaleType() != null && StringUtils.isNotEmpty( filter.getSaleType().getCode() ) ) {
			query.setParameter( "saleType", filter.getSaleType().getCode() );
		}

		if( filter.getStockType() != null && StringUtils.isNotEmpty( filter.getStockType().getCode() ) ) {
			query.setParameter( "stockType", filter.getStockType().getCode() );
		}

		if( filter.getProductionType() != null && StringUtils.isNotEmpty( filter.getProductionType().getCode() ) ) {
			query.setParameter( "productionType", filter.getProductionType().getCode() );
		}

		if( filter.getInsertDate() != null ) {
			query.setParameter( "insertDate", filter.getInsertDate() );
		}

		productList = query.getResultList();

		return productList;
	}

	@Override
	public List < Product > findAll() throws Exception {
		List < Product > productList = null;
		StringBuilder jpql = new StringBuilder();
		jpql.append( " FROM Product " );

		Query query = session.createQuery( jpql.toString() );

		productList = query.getResultList();
		return productList;
	}

}
