package com.sisga.domain.customer;

import com.sisga.domain.person.PersonHistory;
import com.sisga.domain.user.User;

/**
 * 
 * @author Sergio Massao Umiji 10 de mar de 2017
 */

public class CustomerHistory extends PersonHistory {

	private Customer customer;
	private CustomerOperation customerOperation;
	private User uesrSeller;

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer( Customer customer ) {
		this.customer = customer;
	}

	/**
	 * @return the customerOperation
	 */
	public CustomerOperation getCustomerOperation() {
		return customerOperation;
	}

	/**
	 * @param customerOperation
	 *            the customerOperation to set
	 */
	public void setCustomerOperation( CustomerOperation customerOperation ) {
		this.customerOperation = customerOperation;
	}

	/**
	 * @return the uesrSeller
	 */
	public User getUesrSeller() {
		return uesrSeller;
	}

	/**
	 * @param uesrSeller
	 *            the uesrSeller to set
	 */
	public void setUesrSeller( User uesrSeller ) {
		this.uesrSeller = uesrSeller;
	}

}