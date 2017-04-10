package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.provider.ProviderHistory;
import com.sisga.domain.provider.filter.ProviderHistoryFilter;

/**
 * 
 * @author Sergio Massao Umiji
 *         04 de abr de 2017
 */
public class ProviderHistoryDAO extends DomainSpecificEntityDAO < ProviderHistory > {

	@Override
	public List < ProviderHistory > find( AbstractDomainEntity entity ) throws Exception {
		ProviderHistoryFilter filter = ( ProviderHistoryFilter ) entity;
		List < ProviderHistory > providerHistoryList = null;

		StringBuilder jpql = new StringBuilder();

		jpql.append( " SELECT DISTINCT(ph) FROM ProviderHistory ph " );
		jpql.append( " LEFT JOIN ph.provider p " );
		jpql.append( " WHERE 1=1 " );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			jpql.append( " AND p.code like :providerCode " );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			jpql.append( " AND UPPER(p.description) like  :description  " );
		}

		if( filter.getInsertDate() != null ) {
			jpql.append( " AND ph.insertDate =  :insertDate  " );
		}

		Query query = session.createQuery( jpql.toString() );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			query.setParameter( "providerCode", "%" + filter.getCode().toUpperCase() + "%" );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			query.setParameter( "description", "%" + filter.getDescription().toUpperCase() + "%" );
		}

		if( filter.getInsertDate() != null ) {
			query.setParameter( "insertDate", filter.getInsertDate() );
		}

		providerHistoryList = query.getResultList();

		return providerHistoryList;
	}

	@Override
	public List < ProviderHistory > findAll() throws Exception {
		List < ProviderHistory > historyList = null;
		StringBuilder jpql = new StringBuilder();
		jpql.append( " FROM ProviderHistory " );

		Query query = session.createQuery( jpql.toString() );

		historyList = query.getResultList();
		return historyList;
	}

}