package com.sisga.core.business.fieldsvalidator;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.core.business.FieldsValidator;
import com.sisga.core.core.util.Message;
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
			appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.name", Message.ERROR,
					customer ) );
		}

		if( StringUtils.isEmpty( customer.getLastName() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.surname", Message.ERROR,
					customer ) );
		}

		if( StringUtils.isEmpty( customer.getEmail() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.mail", Message.ERROR,
					customer ) );
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
				appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.neighborhood",
						Message.ERROR, customer ) );
			}

			if( StringUtils.isEmpty( customer.getAddress().getNumber() ) ) {
				appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.house.number",
						Message.ERROR, customer ) );
			}

			if( customer.getAddress().getCity() == null ) {
				appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.city", Message.ERROR,
						customer ) );
			}
		} else {
			appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.neighborhood",
					Message.ERROR, customer ) );
			appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.house.number",
					Message.ERROR, customer ) );
			appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.city", Message.ERROR,
					customer ) );
		}

		if( customer.getUserSeller() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.seller", Message.ERROR,
					customer ) );
		}

		if( customer.getTelephones() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.telephone.cellphone",
					Message.ERROR, customer ) );
		}

		if( customer.getTelephones().get( 0 ).getDdd() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.telephone.ddd",
					Message.ERROR, customer ) );
		}
		if( customer.getTelephones().get( 0 ).getPnumber() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.telephone", Message.ERROR,
					customer ) );
		}
		if( customer.getTelephones().get( 1 ).getDdd() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.cellphone.ddd",
					Message.ERROR, customer ) );
		}
		if( customer.getTelephones().get( 1 ).getPnumber() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.cutomer.fields.validator.cellphone", Message.ERROR,
					customer ) );
		}

		return getMessage();
	}

}
