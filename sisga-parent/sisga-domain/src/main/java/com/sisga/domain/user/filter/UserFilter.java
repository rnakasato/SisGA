package com.sisga.domain.user.filter;

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
	private UserType userType;
	private String email;
	private String cpf;
	private String rg;
	private Boolean isLogin;

	public String getUsername() {
		return username;
	}

	public void setUsername( String username ) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType( UserType userType ) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail( String email ) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf( String cpf ) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg( String rg ) {
		this.rg = rg;
	}

	public Boolean getIsLogin() {
		return isLogin;
	}

	public void setIsLogin( Boolean isLogin ) {
		this.isLogin = isLogin;
	}

}
