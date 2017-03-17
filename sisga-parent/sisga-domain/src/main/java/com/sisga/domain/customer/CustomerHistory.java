package com.sisga.domain.customer;

import java.util.List;

import com.sisga.domain.DomainSpecificEntity;
import com.sisga.domain.address.City;
import com.sisga.domain.communication.Telephone;
import com.sisga.domain.user.User;

/**
 * 
 * @author Sergio Massao Umiji
 *         10 de mar de 2017
 */

public class CustomerHistory extends DomainSpecificEntity{

	private Customer customer;
	private CustomerOperation customerOperation;
	private User uesrSeller;
	protected List<Telephone> telephones;
	protected String email;
	protected City city;
	protected String number;
	protected String neighborhood;
	protected String firstName;
	protected String lastName;
	protected boolean active;
	
	public User getUesrSeller() {
		return uesrSeller;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setUesrSeller(User uesrSeller) {
		this.uesrSeller = uesrSeller;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerOperation getCustomerOperation() {
		return customerOperation;
	}
	public void setCustomerOperation(CustomerOperation customerOperation) {
		this.customerOperation = customerOperation;
	}
}