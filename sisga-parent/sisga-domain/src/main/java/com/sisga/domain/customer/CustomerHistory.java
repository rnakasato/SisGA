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
	private User userSeller;

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
	 * @return the userSeller
	 */
	public User getUserSeller() {
		return userSeller;
	}

	/**
	 * @param userSeller
	 *            the userSeller to set
	 */
	public void setUserSeller( User userSeller ) {
		this.userSeller = userSeller;
	}

	public String getOperationCode() {
		String code = null;
		if( this.customerOperation != null ) {
			code = this.customerOperation.getCode();
		}
		return code;
	}

	public void setOperationCode( String code ) {
		if( this.customerOperation == null ) {
			customerOperation = new CustomerOperation();
		}
		customerOperation.setCode( code );
	}

}