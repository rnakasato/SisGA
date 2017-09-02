package com.sisga.core.business.fieldsvalidator;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.core.business.FieldsValidator;
import com.sisga.core.core.util.ListUtils;
import com.sisga.domain.user.User;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         24 de ago de 2017
 */
public class UserFieldsValidator extends FieldsValidator < User > {

	@Override
	public String validate( User entity ) {
		super.init();
		if( entity.getUserType() == null ) {

		}
		if( StringUtils.isEmpty( entity.getUsername() ) ) {

		}
		if( StringUtils.isEmpty( entity.getRg() ) ) {

		}
		if( entity.getActive() == null ) {

		}

		if( entity.getAddress() == null ) {

		}

		if( StringUtils.isEmpty( entity.getCode() ) ) {

		}

		if( StringUtils.isEmpty( entity.getCpf() ) ) {

		}

		if( StringUtils.isEmpty( entity.getEmail() ) ) {

		}

		if( StringUtils.isEmpty( entity.getFirstName() ) ) {

		}

		if( StringUtils.isEmpty( entity.getLastName() ) ) {

		}

		if( StringUtils.isEmpty( entity.getPassword() ) ) {

		}

		if( ListUtils.isEmpty( entity.getTelephones() ) ) {

		}
		if( entity.getDateBirth() == null ) {

		}

		return getMessage();
	}

}
