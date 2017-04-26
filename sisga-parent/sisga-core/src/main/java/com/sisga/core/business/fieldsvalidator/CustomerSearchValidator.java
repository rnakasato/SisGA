package com.sisga.core.business.fieldsvalidator;

import com.sisga.core.core.business.FieldsValidator;
import com.sisga.domain.customer.filter.CustomerFilter;

public class CustomerSearchValidator extends FieldsValidator<CustomerFilter> {

	@Override
	public String validate(CustomerFilter filter) {
		super.init();
		return getMessage();
	}

}