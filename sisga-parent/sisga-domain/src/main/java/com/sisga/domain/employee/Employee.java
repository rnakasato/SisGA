package com.sisga.domain.employee;

import java.util.Date;

import com.sisga.domain.person.SocialPerson;

/**
 * 
 * @author Sergio Massao Umiji
 *         10 de mar de 2017
 */

public class Employee extends SocialPerson{
	private double salary;
	private String workcardNumber;
	private Date employmentDate;
	private Date resignationDate;
	
	public Date getResignationDate() {
		return resignationDate;
	}
	public void setResignationDate(Date resignationDate) {
		this.resignationDate = resignationDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getWorkcardNumber() {
		return workcardNumber;
	}
	public void setWorkcardNumber(String workcardNumber) {
		this.workcardNumber = workcardNumber;
	}
	public Date getEmploymentDate() {
		return employmentDate;
	}
	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}

}
