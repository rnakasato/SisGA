package com.sisga.core.factory.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.core.business.complement.EmployeeHistoryComplementor;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.strategy.IEntityStrategyFactory;
import com.sisga.domain.employee.EmployeeHistory;

/**
 * 
 * @author rafae
 *
 */
public class EmployeeHistoryStrategyFactory implements IEntityStrategyFactory < EmployeeHistory > {

	@Override
	public Map < String, Map < String, List < IStrategy > > > buildEntityRules() {
		Map < String, Map < String, List < IStrategy > > > rns = new HashMap<>();

		Map < String, List < IStrategy > > rnsEmployeeHistory = new HashMap < String, List < IStrategy > >();

		List < IStrategy > rnsSave = new ArrayList<>();
		List < IStrategy > rnsUpdate = new ArrayList<>();
		List < IStrategy > rnsFind = new ArrayList<>();
		List < IStrategy > rnsDelete = new ArrayList<>();

		rnsSave.add( new EmployeeHistoryComplementor() );
		rnsUpdate.add( new EmployeeHistoryComplementor() );
		rnsDelete.add( new EmployeeHistoryComplementor() );

		// Insere as regras de negócio por operação
		rnsEmployeeHistory.put( EOperation.SAVE, rnsSave );
		rnsEmployeeHistory.put( EOperation.UPDATE, rnsUpdate );
		rnsEmployeeHistory.put( EOperation.DELETE, rnsDelete );
		rnsEmployeeHistory.put( EOperation.FIND, rnsFind );

		rns.put( EmployeeHistory.class.getName(), rnsEmployeeHistory );
		return rns;
	}

}
