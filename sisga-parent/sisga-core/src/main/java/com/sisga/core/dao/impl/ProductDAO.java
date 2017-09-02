
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

	public ProductDAO() {
		super( Product.class );
	}
	
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
			jpql.append( " AND UPPER(p.code) like :productCode " );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			jpql.append( " AND UPPER(p.description) like :description  " );
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

		if( filter.isActive() != null ) {
			jpql.append( " AND p.active =  :active  " );
		}

		Query query = session.createQuery( jpql.toString() );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			query.setParameter( "productCode", filter.getCode().toUpperCase() );
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

		if( filter.isActive() != null ) {
			query.setParameter( "active", filter.isActive() );
		}

		productList = query.getResultList();

		return productList;
	}
}
