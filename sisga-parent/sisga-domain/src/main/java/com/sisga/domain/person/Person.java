
package com.sisga.domain.person;

import java.util.List;

import com.sisga.domain.DomainSpecificEntity;
import com.sisga.domain.address.Address;
import com.sisga.domain.communication.Telephone;

/**
 * 
 * @author Sergio Massao Umiji 10 de mar de 2017
 */

public abstract class Person extends DomainSpecificEntity {

	private static final long serialVersionUID = 1L;

	protected List < Telephone > telephones;
	protected String email;
	protected Address address;
	protected String firstName;
	protected String lastName;

	/**
	 * @return the telephones
	 */
	public List < Telephone > getTelephones() {
		return telephones;
	}

	/**
	 * @param telephones
	 *            the telephones to set
	 */
	public void setTelephones( List < Telephone > telephones ) {
		this.telephones = telephones;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail( String email ) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress( Address address ) {
		this.address = address;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

}
