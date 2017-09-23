package com.sisga.core.business.fieldsvalidator;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.core.business.FieldsValidator;
import com.sisga.core.core.util.Message;
import com.sisga.domain.product.Product;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         19 de mar de 2017
 */
public class ProductFieldsValidator extends FieldsValidator < Product > {

	@Override
	public String validate( Product product ) {
		super.init();
		if( StringUtils.isEmpty( product.getDescription() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.product.fields.validator.name", Message.ERROR,
					product ) );
		}

		if( product.getProductionType() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.product.fields.validator.production.type",
					Message.ERROR, product ) );
		}

		if( product.getAmount() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.product.fields.validator.amount", Message.ERROR,
					product ) );
		}

		if( product.getBaseValue() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.product.fields.validator.base.value", Message.ERROR,
					product ) );
		}

		if( product.getSaleType() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.product.fields.validator.sale.type", Message.ERROR,
					product ) );
		}

		return getMessage();
	}

}
