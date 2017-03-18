package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.expense.ExpenseOperation;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         07 de mar de 2017
 */
public class ExpenseOperationDAO extends DomainSpecificEntityDAO < ExpenseOperation > {

	@Override
	public List < ExpenseOperation > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < ExpenseOperation > findAll() throws Exception {
		List < ExpenseOperation > expenseOperationList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM ExpenseOperation " );

			Query query = session.createQuery( jpql.toString() );

			expenseOperationList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return expenseOperationList;

	}

}
