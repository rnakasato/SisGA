package com.sisga.core.business.complement;

import com.sisga.core.core.business.Complementor;
import com.sisga.core.core.util.HashUtils;
import com.sisga.domain.user.filter.UserFilter;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         1 de out de 2017
 */
public class UserLoginComplementor extends Complementor < UserFilter > {

	@Override
	public String complement( UserFilter filter ) {
		if( filter.getIsLogin() != null && filter.getIsLogin() ) {
			String encryptedPassword = HashUtils.encrypt( filter.getPassword() );
			filter.setPassword( encryptedPassword );
		}
		return null;
	}

}
