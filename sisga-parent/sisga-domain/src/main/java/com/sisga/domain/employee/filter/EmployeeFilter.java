package com.sisga.domain.employee.filter;

import java.util.Date;

import com.sisga.domain.employee.Employee;
import com.sisga.domain.filter.impl.DomainSpecificEntityFilter;

/**
 * 
 * @author Sergio Massao Umiji
 *         17 de mar de 2017
 */

public class EmployeeFilter extends DomainSpecificEntityFilter < Employee >{

	private String name;
	private Date employmentDateInit;
	private Date employmentDateFinal;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEmploymentDateInit() {
		return employmentDateInit;
	}
	public void setEmploymentDateInit(Date employmentDateInit) {
		this.employmentDateInit = employmentDateInit;
	}
	public Date getEmploymentDateFinal() {
		return employmentDateFinal;
	}
	public void setEmploymentDateFinal(Date employmentDateFinal) {
		this.employmentDateFinal = employmentDateFinal;
	}
	
	
}
