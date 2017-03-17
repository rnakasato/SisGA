package com.sisga.domain.customer;

import com.sisga.domain.person.LegalPerson;
import com.sisga.domain.user.User;

public class Customer extends LegalPerson {
	private User userSeller;

	public User getUserSeller() {
		return userSeller;
	}

	public void setUserSeller(User userSeller) {
		this.userSeller = userSeller;
	}

	
}
