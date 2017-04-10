package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.employee.EmployeeHistory;
import com.sisga.domain.employee.filter.EmployeeHistoryFilter;

/**
 * 
 * @author Sergio Massao Umiji
 *         05 de abr de 2017
 */
public class EmployeeHistoryDAO extends DomainSpecificEntityDAO < EmployeeHistory > {

	@Override
	public List < EmployeeHistory > find( AbstractDomainEntity entity ) throws Exception {
		EmployeeHistoryFilter filter = ( EmployeeHistoryFilter ) entity;
		List < EmployeeHistory > employeeHistoryList = null;

		StringBuilder jpql = new StringBuilder();

		jpql.append( " SELECT DISTINCT(eh) FROM EmployeeHistory eh " );
		jpql.append( " LEFT JOIN eh.employee e " );
		jpql.append( " WHERE 1=1 " );

		if( StringUtils.isNotEmpty( filter.getCode() ) ) {
			jpql.append( " AND UPPER(e.code) LIKE :employeeCode " );
		}

		if( StringUtils.isNotEmpty( filter.getDescription() ) ) {
			jpql.append( " AND UPPER(e.description) LIKE  :description  " );
		}

		if( filter.getInsertDate() != null ) {
			jpql.append( " AND eh.insertDate =  :insertDate  " );
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

		employeeHistoryList = query.getResultList();

		return employeeHistoryList;
	}

	@Override
	public List < EmployeeHistory > findAll() throws Exception {
		List < EmployeeHistory > historyList = null;
		StringBuilder jpql = new StringBuilder();
		jpql.append( " FROM EmployeeHistory " );

		Query query = session.createQuery( jpql.toString() );

		historyList = query.getResultList();
		return historyList;
	}

}
