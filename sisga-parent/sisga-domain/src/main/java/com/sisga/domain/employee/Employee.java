package com.sisga.domain.employee;

import java.sql.Date;

import com.sisga.domain.person.SocialPerson;

public class Employee extends SocialPerson{
	private double salary;
	private String workcardNumber;
	private String workcardSeries;
	private Date employmentDate;
	
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
	public String getWorkcardSeries() {
		return workcardSeries;
	}
	public void setWorkcardSeries(String workcardSeries) {
		this.workcardSeries = workcardSeries;
	}
	public Date getEmploymentDate() {
		return employmentDate;
	}
	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}

}
