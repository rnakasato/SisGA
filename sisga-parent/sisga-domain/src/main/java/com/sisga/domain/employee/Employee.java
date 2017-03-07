package com.sisga.domain.employee;


public class Employee extends SocialPerson {
	private int number;
	private double salary;
	private CarteiraTrabalho carteiraTrabalho;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public CarteiraTrabalho getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(CarteiraTrabalho carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

}
