package com.sisga.core.factory.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.core.business.complement.CustomerActiveComplementor;
import com.sisga.core.business.complement.CustomerCodeComplementor;
import com.sisga.core.business.complement.CustomerPhoneComplementor;
import com.sisga.core.business.complement.InsertDateComplementor;
import com.sisga.core.business.fieldsvalidator.CustomerFieldsValidator;
import com.sisga.core.business.fieldsvalidator.CustomerSearchValidator;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.strategy.IEntityStrategyFactory;
import com.sisga.domain.customer.Customer;

/**
 * 
 * @author rafae
 *
 */
public class CustomerStrategyFactory implements IEntityStrategyFactory < Customer > {

	@Override
	public Map < String, Map < String, List < IStrategy > > > buildEntityRules() {
		Map < String, Map < String, List < IStrategy > > > rns = new HashMap<>();

		Map < String, List < IStrategy > > rnsCustomer = new HashMap < String, List < IStrategy > >();

		List < IStrategy > rnsSave = new ArrayList<>();
		List < IStrategy > rnsUpdate = new ArrayList<>();
		List < IStrategy > rnsFind = new ArrayList<>();
		List < IStrategy > rnsDelete = new ArrayList<>();

		rnsSave.add( new CustomerActiveComplementor() );
		rnsSave.add( new CustomerCodeComplementor() );
		rnsSave.add( new InsertDateComplementor() );
		rnsSave.add( new CustomerFieldsValidator() );
		rnsSave.add( new CustomerPhoneComplementor() );

		rnsUpdate.add( new CustomerFieldsValidator() );
		rnsUpdate.add( new CustomerPhoneComplementor() );

		rnsFind.add( new CustomerSearchValidator() );

		// Insere as regras de neg�cio por opera��o
		rnsCustomer.put( EOperation.SAVE, rnsSave );
		rnsCustomer.put( EOperation.UPDATE, rnsUpdate );
		rnsCustomer.put( EOperation.DELETE, rnsDelete );
		rnsCustomer.put( EOperation.FIND, rnsFind );
		rns.put( Customer.class.getName(), rnsCustomer );

		return rns;
	}

}
