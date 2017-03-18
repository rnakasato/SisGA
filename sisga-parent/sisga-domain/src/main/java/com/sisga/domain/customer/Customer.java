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

	public User getUserSeller() {
		return userSeller;
	}

	public void setUserSeller( User userSeller ) {
		this.userSeller = userSeller;
	}

}
