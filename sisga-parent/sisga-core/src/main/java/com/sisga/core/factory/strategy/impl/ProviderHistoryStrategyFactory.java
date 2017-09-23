package com.sisga.core.factory.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.core.business.complement.ProviderHistoryComplementor;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.strategy.IEntityStrategyFactory;
import com.sisga.domain.provider.ProviderHistory;

public class ProviderHistoryStrategyFactory implements IEntityStrategyFactory < ProviderHistory > {

	@Override
	public Map < String, Map < String, List < IStrategy > > > buildEntityRules() {
		Map < String, Map < String, List < IStrategy > > > rns = new HashMap <>();

		Map < String, List < IStrategy > > rnsProviderHistory = new HashMap < String, List < IStrategy > >();

		List < IStrategy > rnsSave = new ArrayList <>();
		List < IStrategy > rnsUpdate = new ArrayList <>();
		List < IStrategy > rnsFind = new ArrayList <>();
		List < IStrategy > rnsDelete = new ArrayList <>();

		rnsSave.add( new ProviderHistoryComplementor() );
		rnsUpdate.add( new ProviderHistoryComplementor() );
		rnsDelete.add( new ProviderHistoryComplementor() );

		// Insere as regras de negócio por operação
		rnsProviderHistory.put( EOperation.SAVE, rnsSave );
		rnsProviderHistory.put( EOperation.UPDATE, rnsUpdate );
		rnsProviderHistory.put( EOperation.DELETE, rnsDelete );
		rnsProviderHistory.put( EOperation.FIND, rnsFind );

		rns.put( ProviderHistory.class.getName(), rnsProviderHistory );
		return rns;
	}

}
