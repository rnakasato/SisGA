package com.sisga.domain.employee;

import java.util.Date;
import java.util.List;

import com.sisga.domain.DomainSpecificEntity;
import com.sisga.domain.address.Address;
import com.sisga.domain.address.City;
import com.sisga.domain.communication.Telephone;
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
	private Date employmentDate;
	private Date resignationDate;

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
	public void setEmployee(Employee employee) {
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
	public void setEmployeeOperation(EmployeeOperation employeeOperation) {
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
	public void setSalary(double salary) {
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
	public void setWorkcardNumber(String workcardNumber) {
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
	public void setWorkcardSeries(String workcardSeries) {
		this.workcardSeries = workcardSeries;
	}

	/**
	 * @return the employmentDate
	 */
	public Date getEmploymentDate() {
		return employmentDate;
	}

	/**
	 * @param employmentDate
	 *            the employmentDate to set
	 */
	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}

	/**
	 * @return the resignationDate
	 */
	public Date getResignationDate() {
		return resignationDate;
	}

	/**
	 * @param resignationDate
	 *            the resignationDate to set
	 */
	public void setResignationDate(Date resignationDate) {
		this.resignationDate = resignationDate;
	}

}
