package com.sisga.core.dao.impl;

import java.util.List;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.provider.ProviderOperation;

/**
 * 
 * @author Sergio Massao Umiji 12 de mar de 2017
 */
public class ProviderOperationDAO extends DomainSpecificEntityDAO < ProviderOperation > {

	public ProviderOperationDAO() {
		super( ProviderOperation.class );
	}

	@Override
	public List < ProviderOperation > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
