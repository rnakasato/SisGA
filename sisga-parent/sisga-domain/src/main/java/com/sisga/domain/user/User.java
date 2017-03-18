package com.sisga.domain.user;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.person.SocialPerson;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         10 de mar de 2017
 */
public class User extends SocialPerson {
	private UserType userType;	
	private String email;
	private String username;
	private Boolean active;
	private String password;
	
	
	
	
}
