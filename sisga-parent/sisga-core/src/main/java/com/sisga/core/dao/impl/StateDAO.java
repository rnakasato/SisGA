package com.sisga.core.dao.impl;

import java.util.List;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.address.State;

/**
 * 
 * @author Sergio Massao Umiji
 *         26 de mar de 2017 - find
 */
public class StateDAO extends DomainSpecificEntityDAO < State > {

	public StateDAO() {
		super( State.class );
	}
	
	@Override
	public List < State > find( AbstractDomainEntity entity ) throws Exception {
		return null;
	}
}
