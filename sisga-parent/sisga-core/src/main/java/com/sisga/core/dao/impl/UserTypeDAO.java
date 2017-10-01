package com.sisga.core.dao.impl;

import java.util.List;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.user.UserType;

/**
 * 
 * @author Rafael Hikaru Nakasato
 * 1 de out de 2017
 */
public class UserTypeDAO extends DomainSpecificEntityDAO < UserType >{

	public UserTypeDAO() {
		super( UserType.class );
	}

	@Override
	public List < UserType > find( AbstractDomainEntity entity ) throws Exception {
		return null;
	}

}
