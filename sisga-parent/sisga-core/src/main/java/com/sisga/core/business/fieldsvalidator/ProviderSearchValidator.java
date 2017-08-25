package com.sisga.core.business.fieldsvalidator;

import com.sisga.core.core.business.FieldsValidator;
import com.sisga.domain.provider.filter.ProviderFilter;

public class ProviderSearchValidator extends FieldsValidator < ProviderFilter > {

	@Override
	public String validate( ProviderFilter filter ) {
		super.init();
		return getMessage();
	}

}