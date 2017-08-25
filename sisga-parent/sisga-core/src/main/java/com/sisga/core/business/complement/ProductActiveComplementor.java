package com.sisga.core.business.complement;

import com.sisga.core.core.business.Complementor;
import com.sisga.domain.product.Product;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         19 de mar de 2017
 */
public class ProductActiveComplementor extends Complementor < Product > {

	@Override
	public String complement( Product entity ) {
		entity.setActive( true );
		return null;
	}

}
