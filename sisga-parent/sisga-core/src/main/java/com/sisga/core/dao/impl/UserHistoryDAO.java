package com.sisga.core.dao.impl;

import java.util.List;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.user.UserHistory;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         1 de out de 2017
 */
public class UserHistoryDAO extends AbstractDAO < UserHistory > {

	public UserHistoryDAO() {
		super( UserHistory.class );
	}

	@Override
	public List < UserHistory > find( AbstractDomainEntity entity ) throws Exception {

		return null;
	}

}
