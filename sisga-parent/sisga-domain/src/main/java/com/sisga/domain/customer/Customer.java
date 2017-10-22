package com.sisga.domain.customer;

import com.sisga.domain.person.LegalPerson;
import com.sisga.domain.user.User;

/**
 * 
 * @author Sergio Massao Umiji
 *         10 de mar de 2017
 */

public class Customer extends LegalPerson {
	private User userSeller;
	private boolean active;
	
	public User getUserSeller() {
		return userSeller;
	}

	public void setUserSeller( User userSeller ) {
		this.userSeller = userSeller;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive( boolean active ) {
		this.active = active;
	}
	
	

}
