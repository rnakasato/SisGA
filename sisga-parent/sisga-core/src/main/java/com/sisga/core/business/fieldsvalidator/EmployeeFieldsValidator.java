package com.sisga.core.business.fieldsvalidator;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.core.business.FieldsValidator;
import com.sisga.core.core.util.Message;
import com.sisga.domain.employee.Employee;

/**
 * 
 * @author Sergio Massao Umiji
 *         23 de mar de 2017
 */
public class EmployeeFieldsValidator extends FieldsValidator < Employee > {

	@Override
	public String validate( Employee employee ) {
		super.init();
		if( StringUtils.isEmpty( employee.getFirstName() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.employee.fields.validator.name", Message.ERROR,
					employee ) );
		}

		if( StringUtils.isEmpty( employee.getLastName() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.employee.fields.validator.surname", Message.ERROR,
					employee ) );

		}

		if( StringUtils.isEmpty( employee.getEmail() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.employee.fields.validator.mail", Message.ERROR,
					employee ) );
		} else {
			String email = employee.getEmail().toUpperCase();
			String[] emailSplit01 = email.split( "@" );
			if( emailSplit01.length == 2 ) {
				if( emailSplit01[0].length() > 0 ) {
					if( emailSplit01[1].length() > 2 ) {
						String com = emailSplit01[1];
						String[] emailSplit02 = com.split( ".CO" );
						if( emailSplit02.length > 1 ) {

						} else {
							appendMsg( "Email Inváido" );
						}
					} else {
						appendMsg( "Email Inváido" );
					}
				} else {
					appendMsg( "Email Inváido" );
				}
			} else {
				appendMsg( "Email Inváido" );
			}
		}

		if( StringUtils.isEmpty( employee.getAddress().getNeighborhood() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.employee.fields.validator.neighborhood",
					Message.ERROR, employee ) );
		}

		if( StringUtils.isEmpty( employee.getAddress().getNumber() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.employee.fields.validator.house.number",
					Message.ERROR, employee ) );
		}

		if( StringUtils.isEmpty( employee.getWorkcardNumber() ) ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.employee.fields.validator.workcard", Message.ERROR,
					employee ) );
		}

		if( employee.getAddress().getCity() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.employee.fields.validator.city", Message.ERROR,
					employee ) );
		}

		if( employee.getEmploymentDate() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.employee.fields.validator.employment.date",
					Message.ERROR, employee ) );
		}

		if( employee.getTelephones() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.telephone.cellphone",
					Message.ERROR, employee ) );
		}

		if( employee.getTelephones().get( 0 ).getDdd() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.telephone.ddd",
					Message.ERROR, employee ) );
		}
		if( employee.getTelephones().get( 0 ).getPnumber() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.telephone", Message.ERROR,
					employee ) );
		}
		if( employee.getTelephones().get( 1 ).getDdd() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.cellphone.ddd",
					Message.ERROR, employee ) );
		}
		if( employee.getTelephones().get( 1 ).getPnumber() == null ) {
			appendMsg( Message.getMessage( "com.sisga.core.business.provider.fields.validator.cellphone", Message.ERROR,
					employee ) );
		}

		return getMessage();
	}

}
