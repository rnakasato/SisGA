package com.sisga.core.business.complement;

import java.math.BigInteger;

import javax.persistence.Query;

import org.hibernate.Session;

import com.sisga.core.core.business.Complementor;
import com.sisga.core.hibernate.HibernateUtil;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.provider.Provider;

public class ProviderPhoneComplementor extends Complementor<Provider> {

	@Override
	public String complement(Provider entity) {
		if (!entity.getTelephones().isEmpty()) {
			entity.getTelephones().get(0).setProvider(entity);
			entity.getTelephones().get(1).setProvider(entity);
			return null;
		}
		return ("Numeros de Telefones não informados");
	}
	

}
