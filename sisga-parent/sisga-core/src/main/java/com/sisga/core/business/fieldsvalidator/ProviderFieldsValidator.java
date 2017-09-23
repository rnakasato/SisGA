package com.sisga.core.business.fieldsvalidator;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.core.business.FieldsValidator;
import com.sisga.core.core.util.Message;
import com.sisga.domain.provider.Provider;

/**
 * 
 * @author Sergio Massao Umiji
 *         23 de mar de 2017
 */
public class ProviderFieldsValidator extends FieldsValidator < Provider > {

	@Override
	public String validate( Provider provider ) {
		super.init();
		if( StringUtils.isEmpty( provider.getCorporateName() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.name", Message.ERROR,
					provider ) );
		}

		if( StringUtils.isEmpty( provider.getCnpj() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.cnpj", Message.ERROR,
					provider ) );
		}

		if( StringUtils.isEmpty( provider.getEmail() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.mail", Message.ERROR,
					provider ) );
		} else {
			String email = provider.getEmail().toUpperCase();
			String[] emailSplit01 = email.split( "@" );
			if( emailSplit01.length == 2 ) {
				if( emailSplit01[0].length() > 0 ) {
					if( emailSplit01[1].length() > 2 ) {
						String[] emailSplit02 = email.split( ".CO" );
						if( emailSplit02.length == 2 ) {
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

		if( StringUtils.isEmpty( provider.getAddress().getNeighborhood() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.neighborhood",
					Message.ERROR, provider ) );
		}

		if( StringUtils.isEmpty( provider.getAddress().getNumber() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.house.number",
					Message.ERROR, provider ) );
		}

		if( provider.getAddress().getCity() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.city", Message.ERROR,
					provider ) );
		}
		if( provider.getTelephones() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.telephone.cellphone",
					Message.ERROR, provider ) );
		}

		if( provider.getTelephones().get( 0 ).getDdd() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.telephone.ddd",
					Message.ERROR, provider ) );
		}
		if( provider.getTelephones().get( 0 ).getPnumber() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.telephone", Message.ERROR,
					provider ) );
		}
		if( provider.getTelephones().get( 1 ).getDdd() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.cellphone.ddd",
					Message.ERROR, provider ) );
		}
		if( provider.getTelephones().get( 1 ).getPnumber() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.cellphone", Message.ERROR,
					provider ) );
		}

		return getMessage();
	}

}
