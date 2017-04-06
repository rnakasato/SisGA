package com.sisga.core.business.complement;

import java.math.BigInteger;

import javax.persistence.Query;

import org.hibernate.Session;

import com.sisga.core.core.business.Complementor;
import com.sisga.core.hibernate.HibernateUtil;
import com.sisga.domain.customer.Customer;

public class CustomerPhoneComplementor extends Complementor<Customer> {

	@Override
	public String complement(Customer entity) {
		if (!entity.getTelephones().isEmpty()) {
			entity.getTelephones().get(0).setCustomer(entity);
			entity.getTelephones().get(1).setCustomer(entity);
			return null;
		}
		return ("Numeros de Telefones não informados");
	}

}
