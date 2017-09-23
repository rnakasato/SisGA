package com.sisga.core.business.validator;

import com.sisga.core.business.Validator;
import com.sisga.core.core.util.Message;
import com.sisga.domain.employee.Employee;

/**
 * 
 * @author Sergio Massao Umiji
 *         23 de mar de 2017
 */
public class EmployeeSalaryValidator extends Validator < Employee > {

	@Override
	public String validate( Employee e ) {
		msg = null;
		if( e.getSalary() < getMinSalary() ) {
			msg = Message.getMessage( "com.sisga.core.business.employee.validator.min.salary", Message.ERROR, e );
		}

		return msg;
	}

	private Double getMinSalary() {
		Double minSalary = 960.0;
		return minSalary;
	}

}
