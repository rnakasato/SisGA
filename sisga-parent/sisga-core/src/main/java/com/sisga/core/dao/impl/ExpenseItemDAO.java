package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.expense.ExpenseItem;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         07 de mar de 2017
 */
public class ExpenseItemDAO extends DomainSpecificEntityDAO < ExpenseItem > {

	@Override
	public List < ExpenseItem > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < ExpenseItem > findAll() throws Exception {
		List < ExpenseItem > expenseItemList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM ExpenseItem " );

			Query query = session.createQuery( jpql.toString() );

			expenseItemList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return expenseItemList;
	}

}
