package com.sisga.core.business.fieldsvalidator;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.core.business.FieldsValidator;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.product.Product;

/**
 * 
 * @author Sergio Massao Umiji
 *         23 de mar de 2017
 */
public class CustomerFieldsValidator extends FieldsValidator < Customer > {

	@Override
	public String validate( Customer customer ) {
		super.init();
		if( StringUtils.isEmpty( customer.getFirstName() ) ) {
			appendMsg( "Nome do Cliente" );
		}

		if( StringUtils.isEmpty( customer.getLastName() ) ) {
			appendMsg( "Sobrenome do Cliente" );
		}

		if( StringUtils.isEmpty( customer.getEmail() ) ) {
			appendMsg( "Email do Cliente" );
		}

		if( StringUtils.isEmpty( customer.getNeighborhood() ) ) {
			appendMsg( "Bairro do Cliente" );
		}

		if( StringUtils.isEmpty( customer.getNumber() ) ) {
			appendMsg( "Numero do Cliente" );
		}


		if( customer.getCity() == null ) {
			appendMsg( "Cidade do Cliente" );
		}

		if( customer.getUserSeller() == null ) {
			appendMsg( "Vendedor do Cliente" );
		}
		
		if( customer.getTelephones() == null ) {
			appendMsg( "Telefone e Celular do Cliente" );
		}
		
		if( customer.getTelephones().get(0).getDdd() == null ) {
			appendMsg( "DDD Telefone do Cliente" );
		}
		if( customer.getTelephones().get(0).getPnumber() == null ) {
			appendMsg( "Telefone do Cliente" );
		}
		if( customer.getTelephones().get(1).getDdd() == null ) {
			appendMsg( "DDD Celular do Cliente" );
		}
		if( customer.getTelephones().get(1).getPnumber() == null ) {
			appendMsg( "Celular do Cliente" );
		}
		
		return getMessage();
	}

}
