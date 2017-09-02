package com.sisga.core.dao.impl;

import java.util.List;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.expense.ExpenseOperation;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         07 de mar de 2017
 */
public class ExpenseOperationDAO extends DomainSpecificEntityDAO < ExpenseOperation > {

	public ExpenseOperationDAO() {
		super( ExpenseOperation.class );
	}
	
	@Override
	public List < ExpenseOperation > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
