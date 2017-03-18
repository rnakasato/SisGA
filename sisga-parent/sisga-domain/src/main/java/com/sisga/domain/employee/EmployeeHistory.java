package com.sisga.domain.employee;

import java.sql.Date;
import java.util.List;

import com.sisga.domain.DomainSpecificEntity;
import com.sisga.domain.address.City;
import com.sisga.domain.communication.Telephone;

/**
 * 
 * @author Sergio Massao Umiji
 *         10 de mar de 2017
 */


public class EmployeeHistory extends DomainSpecificEntity{

	private Employee employee;
	private String firstName;
	private String lastName;
	private boolean active;
	private EmployeeOperation employeeOperation;
	private List < Telephone > telephones;
	private String email;
	private City city;
	private String number;
	private String neighborhood;
	private double salary;
	private String workcardNumber;
	private String workcardSeries;
	private Date employmentDate;
	private Date resignationDate;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee( Employee employee ) {
		this.employee = employee;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive( boolean active ) {
		this.active = active;
	}

	public EmployeeOperation getEmployeeOperation() {
		return employeeOperation;
	}

	public void setEmployeeOperation( EmployeeOperation employeeOperation ) {
		this.employeeOperation = employeeOperation;
	}

	public List < Telephone > getTelephones() {
		return telephones;
	}

	public void setTelephones( List < Telephone > telephones ) {
		this.telephones = telephones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail( String email ) {
		this.email = email;
	}

	public City getCity() {
		return city;
	}

	public void setCity( City city ) {
		this.city = city;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber( String number ) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood( String neighborhood ) {
		this.neighborhood = neighborhood;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary( double salary ) {
		this.salary = salary;
	}

	public String getWorkcardNumber() {
		return workcardNumber;
	}

	public void setWorkcardNumber( String workcardNumber ) {
		this.workcardNumber = workcardNumber;
	}

	public String getWorkcardSeries() {
		return workcardSeries;
	}

	public void setWorkcardSeries( String workcardSeries ) {
		this.workcardSeries = workcardSeries;
	}

	public Date getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate( Date employmentDate ) {
		this.employmentDate = employmentDate;
	}

	public Date getResignationDate() {
		return resignationDate;
	}

	public void setResignationDate( Date resignationDate ) {
		this.resignationDate = resignationDate;
	}

}
