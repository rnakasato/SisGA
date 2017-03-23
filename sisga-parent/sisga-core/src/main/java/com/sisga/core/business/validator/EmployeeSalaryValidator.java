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
			msg = "O sal�rio do funcion�rio n�o podeser menor que o sal�rio m�nimo";
		}

		return msg;
	}
	
	private Double getMinSalary(){
		Double minSalary = 960.0;
		return minSalary;
	}

}
