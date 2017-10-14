package com.sisga.domain.user;

import com.sisga.domain.person.SocialPerson;

/**
 * 
 * @author Rafael Hikaru Nakasato 10 de mar de 2017
 */
public class User extends SocialPerson {
	private UserType userType;
	private String username;
	private String password;
	private String oldPassowrd;
	private String newPassowrd;
	private Boolean isFirstLogin;

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType( UserType userType ) {
		this.userType = userType;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
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
	 * @param password
	 *            the password to set
	 */
	public void setPassword( String password ) {
		this.password = password;
	}

	/**
	 * 
	 * @return if the user already did the first login
	 */
	public Boolean getIsFirstLogin() {
		return isFirstLogin;
	}

	/**
	 * 
	 * @param isFirstLogin
	 *            set if is the first login
	 */

	public void setIsFirstLogin( Boolean isFirstLogin ) {
		this.isFirstLogin = isFirstLogin;
	}

	/**
	 * @return the oldPassowrd
	 */
	public String getOldPassowrd() {
		return oldPassowrd;
	}

	/**
	 * @param oldPassowrd
	 *            the oldPassowrd to set
	 */
	public void setOldPassowrd( String oldPassowrd ) {
		this.oldPassowrd = oldPassowrd;
	}

	/**
	 * @return the newPassowrd
	 */
	public String getNewPassowrd() {
		return newPassowrd;
	}

	/**
	 * @param newPassowrd
	 *            the newPassowrd to set
	 */
	public void setNewPassowrd( String newPassowrd ) {
		this.newPassowrd = newPassowrd;
	}

}
