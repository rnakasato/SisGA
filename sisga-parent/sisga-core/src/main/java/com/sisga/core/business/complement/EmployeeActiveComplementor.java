package com.sisga.core.business.complement;

import com.sisga.core.core.business.Complementor;
import com.sisga.domain.employee.Employee;

/**
 * 
 * @author Sergio Massao Umiji
 * 23 de mar de 2017
 */
public class EmployeeActiveComplementor extends Complementor < Employee >{

	@Override
	public String complement( Employee entity ) {
		entity.setActive( true );
		return null;
	}
	
}