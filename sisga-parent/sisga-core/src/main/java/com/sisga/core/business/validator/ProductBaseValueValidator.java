package com.sisga.core.business.validator;

import com.sisga.core.business.Validator;
import com.sisga.core.core.util.Message;
import com.sisga.domain.product.Product;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         19 de mar de 2017
 */
public class ProductBaseValueValidator extends Validator < Product > {

	@Override
	public String validate( Product p ) {
		msg = null;
		if( p.getBaseValue() <= 0 ) {
			msg = Message.getMessage( "com.sisga.core.business.product.validator.base.value.min", Message.ERROR, p );
		}

		return msg;
	}

}
