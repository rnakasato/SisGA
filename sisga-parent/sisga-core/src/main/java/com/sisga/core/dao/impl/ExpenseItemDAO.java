package com.sisga.core.dao.impl;

import java.util.List;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.expense.ExpenseItem;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         07 de mar de 2017
 */
public class ExpenseItemDAO extends DomainSpecificEntityDAO < ExpenseItem > {

	public ExpenseItemDAO() {
		super( ExpenseItem.class );
	}
	
	@Override
	public List < ExpenseItem > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
