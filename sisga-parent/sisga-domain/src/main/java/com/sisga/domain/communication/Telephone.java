package com.sisga.domain.communication;

import com.sisga.domain.DomainSpecificEntity;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.employee.Employee;
import com.sisga.domain.provider.Provider;
import com.sisga.domain.user.User;

/**
 * 
 * @author Sergio Massao Umiji
 *         10 de mar de 2017
 */

public class Telephone extends DomainSpecificEntity {
	private String ddd;
	private String pnumber;
	private PhoneType phoneType;
	private Customer customer;
	private Provider provider;
	private Employee employee;
	private User user;

	public String getDdd() {
		return ddd;
	}

	public void setDdd( String ddd ) {
		this.ddd = ddd;
	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber( String pnumber ) {
		this.pnumber = pnumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer( Customer customer ) {
		this.customer = customer;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider( Provider provider ) {
		this.provider = provider;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee( Employee employee ) {
		this.employee = employee;
	}

	public User getUser() {
		return user;
	}

	public void setUser( User user ) {
		this.user = user;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType( PhoneType phoneType ) {
		this.phoneType = phoneType;
	}

}
