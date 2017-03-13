package com.sisga.domain.customer;

import com.sisga.domain.person.LegalPerson;
import com.sisga.domain.user.User;

public class Customer extends LegalPerson {
	private User uesrSeller;

	public User getUesrSeller() {
		return uesrSeller;
	}

	public void setUesrSeller(User uesrSeller) {
		this.uesrSeller = uesrSeller;
	}

	
}
