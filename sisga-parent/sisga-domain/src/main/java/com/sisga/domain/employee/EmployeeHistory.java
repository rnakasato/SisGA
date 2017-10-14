package com.sisga.domain.employee;

import java.util.Calendar;

import com.sisga.domain.person.PersonHistory;

/**
 * 
 * @author Sergio Massao Umiji 10 de mar de 2017
 */

public class EmployeeHistory extends PersonHistory {

	private Employee employee;

	private EmployeeOperation employeeOperation;
	private double salary;
	private String workcardNumber;
	private String workcardSeries;
	private Calendar employmentDate;
	private Calendar resignationDate;

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee( Employee employee ) {
		this.employee = employee;
	}

	/**
	 * @return the employeeOperation
	 */
	public EmployeeOperation getEmployeeOperation() {
		return employeeOperation;
	}

	/**
	 * @param employeeOperation
	 *            the employeeOperation to set
	 */
	public void setEmployeeOperation( EmployeeOperation employeeOperation ) {
		this.employeeOperation = employeeOperation;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary( double salary ) {
		this.salary = salary;
	}

	/**
	 * @return the workcardNumber
	 */
	public String getWorkcardNumber() {
		return workcardNumber;
	}

	/**
	 * @param workcardNumber
	 *            the workcardNumber to set
	 */
	public void setWorkcardNumber( String workcardNumber ) {
		this.workcardNumber = workcardNumber;
	}

	/**
	 * @return the workcardSeries
	 */
	public String getWorkcardSeries() {
		return workcardSeries;
	}

	/**
	 * @param workcardSeries
	 *            the workcardSeries to set
	 */
	public void setWorkcardSeries( String workcardSeries ) {
		this.workcardSeries = workcardSeries;
	}

	/**
	 * @return the employmentDate
	 */
	public Calendar getEmploymentDate() {
		return employmentDate;
	}

	/**
	 * @param employmentDate
	 *            the employmentDate to set
	 */
	public void setEmploymentDate( Calendar employmentDate ) {
		this.employmentDate = employmentDate;
	}

	/**
	 * @return the resignationDate
	 */
	public Calendar getResignationDate() {
		return resignationDate;
	}

	/**
	 * @param resignationDate
	 *            the resignationDate to set
	 */
	public void setResignationDate( Calendar resignationDate ) {
		this.resignationDate = resignationDate;
	}

	public String getOperationCode() {
		String code = null;
		if( this.employeeOperation != null ) {
			code = this.employeeOperation.getCode();
		}
		return code;
	}

	public void setOperationCode( String code ) {
		if( this.employeeOperation == null ) {
			employeeOperation = new EmployeeOperation();
		}
		employeeOperation.setCode( code );
	}

}
