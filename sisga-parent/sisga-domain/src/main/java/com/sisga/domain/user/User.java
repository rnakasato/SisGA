package com.sisga.domain.user;

import com.sisga.domain.AbstractDomainEntity;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         10 de mar de 2017
 */
public class User extends AbstractDomainEntity {
	private UserType userType;	
	private String email;
	private String username;
	private Boolean active;
	private String password;
	
	
	
	
}
