package com.sisga.core.dao.impl;

import java.util.List;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.customer.CustomerOperation;

/**
 * 
 * @author Sergio Massao Umiji
 *         12 de mar de 2017
 */
public class CustomerOperationDAO extends DomainSpecificEntityDAO < CustomerOperation > {
	
	public CustomerOperationDAO() {
		super( CustomerOperation.class );
	}

	@Override
	public List < CustomerOperation > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}