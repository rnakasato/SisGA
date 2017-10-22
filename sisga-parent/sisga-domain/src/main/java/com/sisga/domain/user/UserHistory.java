package com.sisga.domain.user;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.address.Address;

public class UserHistory extends AbstractDomainEntity {

	private static final long serialVersionUID = 1L;

	private User user;
	private UserType userType;
	private String email;
	private String username;
	private String password;
	private Boolean isFirstLogin;
	private String cpf;
	private String rg;
	private Address address;
	private String firstName;
	private String lastName;
	private UserOperation userOparation;	

	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser( User user ) {
		this.user = user;
	}

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType( UserType userType ) {
		this.userType = userType;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail( String email ) {
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername( String username ) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword( String password ) {
		this.password = password;
	}

	/**
	 * @return the isFirstLogin
	 */
	public Boolean getIsFirstLogin() {
		return isFirstLogin;
	}

	/**
	 * @param isFirstLogin the isFirstLogin to set
	 */
	public void setIsFirstLogin( Boolean isFirstLogin ) {
		this.isFirstLogin = isFirstLogin;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
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
	 * @param rg the rg to set
	 */
	public void setRg( String rg ) {
		this.rg = rg;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
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
	 * @param firstName the firstName to set
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
	 * @param lastName the lastName to set
	 */
	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

	/**
	 * @return the userOparation
	 */
	public UserOperation getUserOparation() {
		return userOparation;
	}

	/**
	 * @param userOparation the userOparation to set
	 */
	public void setUserOparation( UserOperation userOparation ) {
		this.userOparation = userOparation;
	}

	public void setOperationCode( String code ) {
		if( this.userOparation == null ) {
			userOparation = new UserOperation();
		}
		userOparation.setCode( code );
	}

	public String getOperationCode() {
		String code = null;
		if( this.userOparation != null ) {
			code = this.userOparation.getCode();
		}
		return code;
	}

}
