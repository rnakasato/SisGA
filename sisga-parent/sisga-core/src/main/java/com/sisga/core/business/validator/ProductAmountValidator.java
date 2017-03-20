package com.sisga.core.business.validator;

import com.sisga.core.business.Validator;
import com.sisga.domain.product.Product;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         19 de mar de 2017
 */
public class ProductAmountValidator extends Validator < Product > {

	@Override
	public String validate( Product p ) {
		msg = null;
		if( p.getAmount() == 0 ) {
			msg = "A quantidade em estoque deve ser maior do que 0";
		}

		return msg;
	}

}
