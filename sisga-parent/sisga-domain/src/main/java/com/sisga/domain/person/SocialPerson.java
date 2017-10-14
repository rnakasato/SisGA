
package com.sisga.domain.person;

import java.util.Calendar;

/**
 * 
 * @author Sergio Massao Umiji
 *         10 de mar de 2017
 */

public abstract class SocialPerson extends Person {

	protected String cpf;
	protected String rg;

	protected Calendar birthDate;

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
		
	/**
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf( String cpf ) {
		this.cpf = cpf;
	}

	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * @param rg
	 *            the rg to set
	 */
	public void setRg( String rg ) {
		this.rg = rg;
	}

	/**
	 * @return the dateBirth
	 */
	public Calendar getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the dateBirth to set
	 */
	public void setBirthDate( Calendar birthDate ) {
		this.birthDate = birthDate;
	}

}
