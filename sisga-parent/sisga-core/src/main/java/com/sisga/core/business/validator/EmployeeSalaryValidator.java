package com.sisga.core.business.validator;

import com.sisga.core.business.Validator;
import com.sisga.domain.employee.Employee;
import com.sisga.domain.product.Product;

/**
 * 
 * @author Sergio Massao Umiji
 *         23 de mar de 2017
 */
public class EmployeeSalaryValidator extends Validator < Employee > {

	@Override
	public String validate( Employee e ) {
		msg = null;
		if( e.getSalary() <= getMinSalary() ) {
			msg = "O salário do funcionário não podeser menor que o salário mínimo";
		}

		return msg;
	}
	
	private Double getMinSalary(){
		Double minSalary = 960.0;
		return minSalary;
	}

}
