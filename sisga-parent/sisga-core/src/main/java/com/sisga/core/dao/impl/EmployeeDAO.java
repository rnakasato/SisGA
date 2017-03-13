package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.employee.Employee;

/**
 * 
 * @author Sergio Massao Umiji 7 de mar de 2017
 */
public class EmployeeDAO extends DomainSpecificEntityDAO < Employee > {

	@Override
	public List < Employee > find( Employee funcionario ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < Employee > findAll() throws Exception {
		List < Employee > employeeList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM Employee " );

			Query query = session.createQuery( jpql.toString() );

			employeeList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return employeeList;
	}

}
