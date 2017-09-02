package com.sisga.core.dao.impl;

import java.util.List;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.employee.EmployeeOperation;

/**
 * 
 * @author Sergio Massao Umiji
 *         12 de mar de 2017
 */
public class EmployeeOperationDAO extends DomainSpecificEntityDAO < EmployeeOperation > {

	public EmployeeOperationDAO() {
		super( EmployeeOperation.class );
	}

	@Override
	public List < EmployeeOperation > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}