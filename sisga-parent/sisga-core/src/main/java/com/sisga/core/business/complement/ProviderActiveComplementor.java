package com.sisga.core.business.complement;

import com.sisga.core.core.business.Complementor;
import com.sisga.domain.provider.Provider;

/**
 * 
 * @author Sergio Massao Umiji
 * 23 de mar de 2017
 */
public class ProviderActiveComplementor extends Complementor < Provider >{

	@Override
	public String complement( Provider entity ) {
		entity.setActive( true );
		return null;
	}
	
}