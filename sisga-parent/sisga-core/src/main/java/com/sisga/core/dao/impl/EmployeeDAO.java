package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.employee.Employee;
import com.sisga.domain.employee.filter.EmployeeFilter;

/**
 * 
 * @author Sergio Massao Umiji 
 * 7 de mar de 2017
 * 17 de mar de 2017 - find
 */
public class EmployeeDAO extends DomainSpecificEntityDAO < Employee > {
	private EmployeeFilter employeeFilter;
	
	@Override
	public List < Employee > find( AbstractDomainEntity entity ) throws Exception {
		employeeFilter = (EmployeeFilter) entity;
		List < Employee > employeeList = null;
		
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " SELECT DISTINCT (e) FROM Employee e" );
			jpql.append( " LEFT JOIN e.city ec " );
			jpql.append( " LEFT JOIN e.cellphone em " );
			jpql.append( " LEFT JOIN e.telephone et " );
			jpql.append( " WHERE 1=1 " );
			
			if( StringUtils.isNotEmpty( employeeFilter.getName() ) ) {
				jpql.append( " AND e.name = :name " );
			}
			if( employeeFilter.getEmploymentDateInit() != null && employeeFilter.getEmploymentDateFinal() != null ) {
				jpql.append( " AND e.employmentDate BETWEEN :initDate AND :finalDate " );
			}
				
			Query query = session.createQuery( jpql.toString() );
			
			if( StringUtils.isNotEmpty( employeeFilter.getName() ) ) {
				query.setParameter( "name", employeeFilter.getName() );
			}
			if( employeeFilter.getEmploymentDateInit() != null ) {
				query.setParameter( "initDate", employeeFilter.getEmploymentDateInit() );
			}
			if( employeeFilter.getEmploymentDateFinal() != null ) {
				query.setParameter( "finalDate", employeeFilter.getEmploymentDateFinal() );
			}

			employeeList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return employeeList;
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
