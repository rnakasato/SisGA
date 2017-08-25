package com.sisga.core.business.complement;

import com.sisga.core.core.business.Complementor;
import com.sisga.core.core.util.CSPRNGUtil;
import com.sisga.domain.provider.Provider;

/**
 * 
 * @author Sergio Massao Umiji
 *         23 de mar de 2017
 */
public class ProviderCodeComplementor extends Complementor < Provider > {

	@Override
	public String complement( Provider entity ) {
		entity.setCode( CSPRNGUtil.generateHex( CSPRNGUtil.BYTE_02 ) );
		return null;
	}

}
