package com.sisga.core.dao.impl;

import java.util.List;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.expense.ExpenseStatus;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         07 de mar de 2017
 */
public class ExpenseStatusDAO extends DomainSpecificEntityDAO < ExpenseStatus > {

	public ExpenseStatusDAO() {
		super( ExpenseStatus.class );
	}
	
	@Override
	public List < ExpenseStatus > find( AbstractDomainEntity entity ) throws Exception {

		return null;
	}


}
