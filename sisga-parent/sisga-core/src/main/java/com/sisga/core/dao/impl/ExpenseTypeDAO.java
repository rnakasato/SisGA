package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.expense.ExpenseType;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         07 de mar de 2017
 */
public class ExpenseTypeDAO extends DomainSpecificEntityDAO < ExpenseType > {

	@Override
	public List < ExpenseType > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < ExpenseType > findAll() throws Exception {
		List < ExpenseType > expenseTypeList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM ExpenseType " );

			Query query = session.createQuery( jpql.toString() );

			expenseTypeList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return expenseTypeList;

	}

}
