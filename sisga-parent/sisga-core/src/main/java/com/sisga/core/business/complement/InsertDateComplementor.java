package com.sisga.core.business.complement;

import java.util.Date;

import com.sisga.core.core.business.Complementor;
import com.sisga.domain.AbstractDomainEntity;

/**
 * 
 * @author Rafael Hikaru Nakasato
 * 19 de mar de 2017
 */
public class InsertDateComplementor extends Complementor < AbstractDomainEntity > {

	@Override
	public String complement( AbstractDomainEntity entity ) {
		entity.setInsertDate( new Date() );
		return null;
	}

}
