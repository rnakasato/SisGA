package com.sisga.domain.employee;

public class Employee {
	private int number;
	private double salary;
	private WorkCard workcard;

	public int getNumber() {
		return number;
	}

	public void setNumber( int number ) {
		this.number = number;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary( double salary ) {
		this.salary = salary;
	}

	public WorkCard getWorkcard() {
		return workcard;
	}

	public void setWorkcard( WorkCard workcard ) {
		this.workcard = workcard;
	}

}
