package com.sisga.domain.employee.filter;

import java.util.Calendar;

import com.sisga.domain.employee.Employee;
import com.sisga.domain.filter.impl.DomainSpecificEntityFilter;

/**
 * 
 * @author Sergio Massao Umiji
 *         17 de mar de 2017
 */

public class EmployeeFilter extends DomainSpecificEntityFilter < Employee > {

	private String name;
	private String status;
	private Calendar employmentDateInit;
	private Calendar employmentDateFinal;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName( String name ) {
		this.name = name;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus( String status ) {
		this.status = status;
	}

	/**
	 * @return the employmentDateInit
	 */
	public Calendar getEmploymentDateInit() {
		return employmentDateInit;
	}

	/**
	 * @param employmentDateInit
	 *            the employmentDateInit to set
	 */
	public void setEmploymentDateInit( Calendar employmentDateInit ) {
		this.employmentDateInit = employmentDateInit;
	}

	/**
	 * @return the employmentDateFinal
	 */
	public Calendar getEmploymentDateFinal() {
		return employmentDateFinal;
	}

	/**
	 * @param employmentDateFinal
	 *            the employmentDateFinal to set
	 */
	public void setEmploymentDateFinal( Calendar employmentDateFinal ) {
		this.employmentDateFinal = employmentDateFinal;
	}

}
