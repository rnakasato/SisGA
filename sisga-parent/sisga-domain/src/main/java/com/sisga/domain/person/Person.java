
package com.sisga.domain.person;

import java.util.List;

import com.sisga.domain.DomainSpecificEntity;
import com.sisga.domain.address.City;
import com.sisga.domain.communication.Telephone;

/**
 * 
 * @author Sergio Massao Umiji
 *         10 de mar de 2017
 */

public abstract class Person extends DomainSpecificEntity  {
	
	protected Telephone telephone;
	protected Telephone cellphone;
	protected String email;
	protected City city;
	protected String number;
	protected String neighborhood;
	protected String name;
	protected boolean active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive( boolean active ) {
		this.active = active;
	}

	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Telephone getTelephone() {
		return telephone;
	}

	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
	}

	public Telephone getCellphone() {
		return cellphone;
	}

	public void setCellphone(Telephone cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
	
	}
