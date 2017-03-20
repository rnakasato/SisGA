package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.core.util.ListUtils;
import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.product.SaleType;
import com.sisga.domain.product.filter.SaleTypeFilter;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         7 de mar de 2017
 */
public class SaleTypeDAO extends DomainSpecificEntityDAO < SaleType > {

	@Override
	public List < SaleType > find( AbstractDomainEntity entity ) throws Exception {
		SaleTypeFilter filter = ( SaleTypeFilter ) entity;
		List < SaleType > saleTypeList = null;

		StringBuilder jpql = new StringBuilder();

		jpql.append( " SELECT DISTINCT(st) FROM SaleType st " );
		jpql.append( " WHERE 1=1 " );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			jpql.append( " AND st.code like :saleTypeCode " );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			jpql.append( " AND st.description like :description " );
		}

		Query query = session.createQuery( jpql.toString() );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			query.setParameter( "saleTypeCode", "%" + filter.getCode().toUpperCase() + "%" );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			query.setParameter( "description", "%" + filter.getDescription().toUpperCase() + "%" );
		}

		saleTypeList = query.getResultList();

		return saleTypeList;

	}

	public SaleType findSingle( AbstractDomainEntity entity ) throws Exception {
		SaleTypeFilter filter = ( SaleTypeFilter ) entity;
		SaleType saleType = null;

		StringBuilder jpql = new StringBuilder();

		jpql.append( " SELECT DISTINCT(st) FROM SaleType st " );
		jpql.append( " WHERE 1=1 " );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			jpql.append( " AND UPPER(st.code) like (:saleTypeCode) " );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			jpql.append( " AND UPPER(st.description) like :description " );
		}

		Query query = session.createQuery( jpql.toString() );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			query.setParameter( "saleTypeCode", filter.getCode().toUpperCase() );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			query.setParameter( "description", filter.getDescription().toUpperCase() );
		}
		query.setMaxResults( 1 );

		List < SaleType > resultList = query.getResultList();
		if( ListUtils.isNotEmpty( resultList ) ) {
			saleType = resultList.get( 0 );
		}

		return saleType;

	}

	@Override
	public List < SaleType > findAll() throws Exception {
		List < SaleType > saleTypeList = null;
		StringBuilder jpql = new StringBuilder();
		jpql.append( " FROM SaleType " );

		Query query = session.createQuery( jpql.toString() );

		saleTypeList = query.getResultList();

		return saleTypeList;
	}

}
