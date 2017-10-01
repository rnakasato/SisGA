package com.sisga.domain.user;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.address.Address;

public class UserHistory extends AbstractDomainEntity {

	private static final long serialVersionUID = 1L;
	
	
	private UserType userType;
	private String email;
	private String username;
	private String password;
	private Boolean isFirstLogin;
	private String cpf;
	private String rg;
	private Address address;
	private boolean active;
	private String firstName;
	private String lastName;
	private UserOperation userOparation;

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

	public Boolean getIsFirstLogin() {
		return isFirstLogin;
	}

	public void setIsFirstLogin( Boolean isFirstLogin ) {
		this.isFirstLogin = isFirstLogin;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress( Address address ) {
		this.address = address;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive( boolean active ) {
		this.active = active;
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

	public UserOperation getUserOparation() {
		return userOparation;
	}

	public void setUserOparation( UserOperation userOparation ) {
		this.userOparation = userOparation;
	}

}
