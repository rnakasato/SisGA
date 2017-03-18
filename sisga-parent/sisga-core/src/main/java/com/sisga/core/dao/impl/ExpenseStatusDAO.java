package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.expense.ExpenseStatus;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         07 de mar de 2017
 */
public class ExpenseStatusDAO extends DomainSpecificEntityDAO < ExpenseStatus > {

	@Override
	public List < ExpenseStatus > find( AbstractDomainEntity entity ) throws Exception {
		
		return null;
	}

	@Override
	public List < ExpenseStatus > findAll() throws Exception {
		List < ExpenseStatus > expenseStatusList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM ExpenseStatus " );

			Query query = session.createQuery( jpql.toString() );

			expenseStatusList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return expenseStatusList;

	}

}
