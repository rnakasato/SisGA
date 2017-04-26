package com.sisga.core.business.fieldsvalidator;

import com.sisga.core.core.business.FieldsValidator;
import com.sisga.domain.employee.filter.EmployeeFilter;

/**
 * 
 * @author Sergio Massao Umiji
 *         26 de abr de 2017
 */
public class EmployeeSearchValidator extends FieldsValidator < EmployeeFilter > {

	@Override
	public String validate( EmployeeFilter filter ) {
		super.init();
		if( filter.getEmploymentDateInit() == null ) {
			appendMsg( "Data inicial n�o informada" );
		}

		if( filter.getEmploymentDateFinal() == null ) {
			appendMsg( "Data final n�o informada" );
		}
		
		return getMessage();
	}

}
