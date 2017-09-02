package com.sisga.core.dao.impl;

import java.util.List;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.expense.ExpenseType;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         07 de mar de 2017
 */
public class ExpenseTypeDAO extends DomainSpecificEntityDAO < ExpenseType > {

	public ExpenseTypeDAO() {
		super( ExpenseType.class );
	}

	@Override
	public List < ExpenseType > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
