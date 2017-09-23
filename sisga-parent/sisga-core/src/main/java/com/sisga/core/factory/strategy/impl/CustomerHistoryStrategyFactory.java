package com.sisga.core.factory.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.core.business.complement.CustomerHistoryComplementor;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.strategy.IEntityStrategyFactory;
import com.sisga.domain.customer.CustomerHistory;

public class CustomerHistoryStrategyFactory implements IEntityStrategyFactory < CustomerHistory > {

	@Override
	public Map < String, Map < String, List < IStrategy > > > buildEntityRules() {

		Map < String, Map < String, List < IStrategy > > > rns = new HashMap <>();

		Map < String, List < IStrategy > > rnsCustomerHistory = new HashMap < String, List < IStrategy > >();

		List < IStrategy > rnsSave = new ArrayList <>();
		List < IStrategy > rnsUpdate = new ArrayList <>();
		List < IStrategy > rnsFind = new ArrayList <>();
		List < IStrategy > rnsDelete = new ArrayList <>();

		rnsSave.add( new CustomerHistoryComplementor() );
		rnsUpdate.add( new CustomerHistoryComplementor() );
		rnsDelete.add( new CustomerHistoryComplementor() );

		// Insere as regras de negócio por operação
		rnsCustomerHistory.put( EOperation.SAVE, rnsSave );
		rnsCustomerHistory.put( EOperation.UPDATE, rnsUpdate );
		rnsCustomerHistory.put( EOperation.DELETE, rnsDelete );
		rnsCustomerHistory.put( EOperation.FIND, rnsFind );

		return rns;
	}

}
