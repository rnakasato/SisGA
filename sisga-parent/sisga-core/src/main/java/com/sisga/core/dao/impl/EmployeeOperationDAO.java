package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.employee.EmployeeOperation;

/**
 * 
 * @author Sergio Massao Umiji
 *         12 de mar de 2017
 */
public class EmployeeOperationDAO extends DomainSpecificEntityDAO < EmployeeOperation > {

	@Override
	public List < EmployeeOperation > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < EmployeeOperation > findAll() throws Exception {
		List < EmployeeOperation > OperationList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM EmployeeOperation " );

			Query query = session.createQuery( jpql.toString() );

			OperationList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return OperationList;

	}

}