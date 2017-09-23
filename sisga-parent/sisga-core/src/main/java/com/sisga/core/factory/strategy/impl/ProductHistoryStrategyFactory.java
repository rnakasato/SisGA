package com.sisga.core.factory.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.core.business.complement.ProductHistoryComplementor;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.strategy.IEntityStrategyFactory;
import com.sisga.domain.product.ProductHistory;

/**
 * 
 * @author rafae
 *
 */
public class ProductHistoryStrategyFactory implements IEntityStrategyFactory < ProductHistory > {

	@Override
	public Map < String, Map < String, List < IStrategy > > > buildEntityRules() {
		Map < String, Map < String, List < IStrategy > > > rns = new HashMap < String, Map < String, List < IStrategy > > >();

		Map < String, List < IStrategy > > rnsProductHistory = new HashMap <>();

		List < IStrategy > rnsSave = new ArrayList <>();
		List < IStrategy > rnsUpdate = new ArrayList <>();
		// Não há regras para a busca de produto
		List < IStrategy > rnsFind = new ArrayList <>();
		List < IStrategy > rnsDelete = new ArrayList <>();

		rnsSave.add( new ProductHistoryComplementor() );

		// Insere as regras de negócio por operação
		rnsProductHistory.put( EOperation.SAVE, rnsSave );
		rnsProductHistory.put( EOperation.UPDATE, rnsUpdate );
		rnsProductHistory.put( EOperation.DELETE, rnsDelete );
		rnsProductHistory.put( EOperation.FIND, rnsFind );

		rns.put( ProductHistory.class.getName(), rnsProductHistory );

		return rns;
	}

}
