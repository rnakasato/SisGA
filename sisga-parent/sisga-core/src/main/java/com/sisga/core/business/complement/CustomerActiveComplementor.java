package com.sisga.core.business.complement;

import com.sisga.core.core.business.Complementor;
import com.sisga.domain.customer.Customer;

/**
 * 
 * @author Sergio Massao Umiji
 *         23 de mar de 2017
 */
public class CustomerActiveComplementor extends Complementor < Customer > {

	@Override
	public String complement( Customer entity ) {
		entity.setActive( true );
		return null;
	}

}