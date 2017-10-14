package com.sisga.core.dao.impl;

import java.util.List;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.user.UserOperation;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         1 de out de 2017
 */
public class UserOperationDAO extends DomainSpecificEntityDAO < UserOperation > {

	public UserOperationDAO() {
		super( UserOperation.class );
	}

	@Override
	public List < UserOperation > find( AbstractDomainEntity entity ) throws Exception {

		return null;
	}

}
