package com.sisga.domain.user.filter;

import java.util.Calendar;

import com.sisga.domain.filter.impl.Filter;
import com.sisga.domain.user.User;
import com.sisga.domain.user.UserType;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         1 de out de 2017
 */
public class UserFilter extends Filter < User > {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String status;
	private String firstLogin;
	private String code;
	private UserType userType;
	private String email;
	private String cpf;
	private String rg;
	private Boolean isLogin;
	private Calendar insertDateInit;
	private Calendar insertDateFinal;
	private Calendar birthDateInit;
	private Calendar birthDateFinal;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
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
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail( String email ) {
		this.email = email;
	}

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
	 * @return the isLogin
	 */
	public Boolean getIsLogin() {
		return isLogin;
	}

	/**
	 * @param isLogin
	 *            the isLogin to set
	 */
	public void setIsLogin( Boolean isLogin ) {
		this.isLogin = isLogin;
	}

	/**
	 * @return the insertDateInit
	 */
	public Calendar getInsertDateInit() {
		return insertDateInit;
	}

	/**
	 * @param insertDateInit
	 *            the insertDateInit to set
	 */
	public void setInsertDateInit( Calendar insertDateInit ) {
		this.insertDateInit = insertDateInit;
	}

	/**
	 * @return the insertDateFinal
	 */
	public Calendar getInsertDateFinal() {
		return insertDateFinal;
	}

	/**
	 * @param insertDateFinal
	 *            the insertDateFinal to set
	 */
	public void setInsertDateFinal( Calendar insertDateFinal ) {
		this.insertDateFinal = insertDateFinal;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus( String status ) {
		this.status = status;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode( String code ) {
		this.code = code;
	}

	/**
	 * @return the birthDateInit
	 */
	public Calendar getBirthDateInit() {
		return birthDateInit;
	}

	/**
	 * @param birthDateInit
	 *            the birthDateInit to set
	 */
	public void setBirthDateInit( Calendar birthDateInit ) {
		this.birthDateInit = birthDateInit;
	}

	/**
	 * @return the birthDateFinal
	 */
	public Calendar getBirthDateFinal() {
		return birthDateFinal;
	}

	/**
	 * @param birthDateFinal
	 *            the birthDateFinal to set
	 */
	public void setBirthDateFinal( Calendar birthDateFinal ) {
		this.birthDateFinal = birthDateFinal;
	}

	/**
	 * @return the firstLogin
	 */
	public String getFirstLogin() {
		return firstLogin;
	}

	/**
	 * @param firstLogin
	 *            the firstLogin to set
	 */
	public void setFirstLogin( String firstLogin ) {
		this.firstLogin = firstLogin;
	}

}
