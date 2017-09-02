package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.customer.CustomerHistory;
import com.sisga.domain.customer.filter.CustomerHistoryFilter;

/**
 * 
 * @author Sergio Massao Umiji
 *         03 de abr de 2017
 */
public class CustomerHistoryDAO extends DomainSpecificEntityDAO < CustomerHistory > {

	public CustomerHistoryDAO() {
		super( CustomerHistory.class );
	}

	@Override
	public List < CustomerHistory > find( AbstractDomainEntity entity ) throws Exception {
		CustomerHistoryFilter filter = ( CustomerHistoryFilter ) entity;
		List < CustomerHistory > customerHistoryList = null;

		StringBuilder jpql = new StringBuilder();

		jpql.append( " SELECT DISTINCT(ch) FROM CustomerHistory ch " );
		jpql.append( " LEFT JOIN ch.customer c " );
		jpql.append( " WHERE 1=1 " );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			jpql.append( " AND c.code like :customerCode " );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			jpql.append( " AND UPPER(c.description) like  :description  " );
		}

		if( filter.getInsertDate() != null ) {
			jpql.append( " AND ch.insertDate =  :insertDate  " );
		}

		Query query = session.createQuery( jpql.toString() );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			query.setParameter( "employeeCode", "%" + filter.getCode().toUpperCase() + "%" );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			query.setParameter( "description", "%" + filter.getDescription().toUpperCase() + "%" );
		}

		if( filter.getInsertDate() != null ) {
			query.setParameter( "insertDate", filter.getInsertDate() );
		}

		customerHistoryList = query.getResultList();

		return customerHistoryList;
	}

}
