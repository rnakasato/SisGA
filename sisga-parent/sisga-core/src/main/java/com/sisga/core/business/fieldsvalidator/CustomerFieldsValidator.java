package com.sisga.core.business.fieldsvalidator;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.core.business.FieldsValidator;
import com.sisga.domain.customer.Customer;

/**
 * 
 * @author Sergio Massao Umiji 23 de mar de 2017 10 de abr de 2017 - email
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
		} else {
			String email = customer.getEmail().toUpperCase();
			String[] emailSplit01 = email.split( "@" );
			if( emailSplit01.length == 2 ) {
				if( emailSplit01[0].length() > 0 ) {
					if( emailSplit01[1].length() > 2 ) {
						String[] emailSplit02 = email.split( ".CO" );
						if( emailSplit02.length > 1 ) {
						} else {
							appendMsg( "Email Inválido" );
						}
					} else {
						appendMsg( "Email Inválido" );
					}
				} else {
					appendMsg( "Email Inválido" );
				}
			} else {
				appendMsg( "Email Inválido" );
			}
		}

		if( customer.getAddress() != null ) {
			if( StringUtils.isEmpty( customer.getAddress().getNeighborhood() ) ) {
				appendMsg( "Bairro do Cliente" );
			}

			if( StringUtils.isEmpty( customer.getAddress().getNumber() ) ) {
				appendMsg( "Numero do Cliente" );
			}

			if( customer.getAddress().getCity() == null ) {
				appendMsg( "Cidade do Cliente" );
			}
		} else {
			appendMsg( "Bairro do Cliente" );
			appendMsg( "Numero do Cliente" );
			appendMsg( "Cidade do Cliente" );
		}

		if( customer.getUserSeller() == null ) {
			appendMsg( "Vendedor do Cliente" );
		}

		if( customer.getTelephones() == null ) {
			appendMsg( "Telefone e Celular do Cliente" );
		}

		if( customer.getTelephones().get( 0 ).getDdd() == null ) {
			appendMsg( "DDD Telefone do Cliente" );
		}
		if( customer.getTelephones().get( 0 ).getPnumber() == null ) {
			appendMsg( "Telefone do Cliente" );
		}
		if( customer.getTelephones().get( 1 ).getDdd() == null ) {
			appendMsg( "DDD Celular do Cliente" );
		}
		if( customer.getTelephones().get( 1 ).getPnumber() == null ) {
			appendMsg( "Celular do Cliente" );
		}

		return getMessage();
	}

}
