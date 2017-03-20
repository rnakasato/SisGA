package com.sisga.core.business.complement;

import com.sisga.core.core.business.Complementor;
import com.sisga.core.core.util.CSPRNGUtil;
import com.sisga.domain.product.Product;

/**
 * 
 * @author Rafael Hikaru Nakasato
 * 19 de mar de 2017
 */
public class ProductCodeComplementor extends Complementor < Product >{

	@Override
	public String complement( Product entity ) {
		entity.setCode( CSPRNGUtil.generateHex( CSPRNGUtil.BYTE_02 ) );
		return null;
	}

}
