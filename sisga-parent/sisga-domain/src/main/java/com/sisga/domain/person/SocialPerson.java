
package com.sisga.domain.person;

import java.util.Date;

/**
 * 
 * @author Sergio Massao Umiji
 *         10 de mar de 2017
 */

public abstract class SocialPerson extends Person {

	protected String cpf;
	protected String rg;

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

	protected Date dateBirth;

	public String getCpf() {
		return cpf;
	}

	public void setCpf( String cpf ) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg( String rg ) {
		this.rg = rg;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth( Date dateBirth ) {
		this.dateBirth = dateBirth;
	}

}
