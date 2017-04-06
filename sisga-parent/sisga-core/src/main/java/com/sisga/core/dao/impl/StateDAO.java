package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.address.State;

/**
 * 
 * @author Sergio Massao Umiji 
 * 26 de mar de 2017  - find
 */
public class StateDAO extends DomainSpecificEntityDAO < State > {

	@Override
	public List<State> find(AbstractDomainEntity entity) throws Exception {
		return null;
	}

	@Override
	public List < State > findAll() throws Exception {
		List < State > stateList = null;

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM State " );

			Query query = session.createQuery( jpql.toString() );

			stateList = query.getResultList();

			return stateList;
	}	
}
