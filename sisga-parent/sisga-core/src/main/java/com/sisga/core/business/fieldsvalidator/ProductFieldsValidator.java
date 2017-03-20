package com.sisga.core.business.fieldsvalidator;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.core.business.FieldsValidator;
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
			appendMsg( "Nome do Produto" );
		}

		if( product.getProductionType() == null ) {
			appendMsg( "Produção por" );
		}

		if( product.getAmount() == null ) {
			appendMsg( "Quantidade" );
		}

		if( product.getBaseValue() == null ) {
			appendMsg( "Valor base de venda" );
		}

		if( product.getSaleType() == null ) {
			appendMsg( "Venda por" );
		}

		return getMessage();
	}

}
