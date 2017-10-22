package com.sisga.domain.employee;

import java.util.Calendar;

import com.sisga.domain.person.SocialPerson;

/**
 * 
 * @author Sergio Massao Umiji
 *         10 de mar de 2017
 */

public class Employee extends SocialPerson {
	private double salary;
	private String workcardNumber;
	private String workcardSeries;
	private Calendar employmentDate;
	private Calendar resignationDate;
	private boolean active;

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

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive( boolean active ) {
		this.active = active;
	}

}
