package com.sisga.core.factory.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.strategy.IEntityStrategyFactory;
import com.sisga.core.factory.strategy.impl.CustomerHistoryStrategyFactory;
import com.sisga.core.factory.strategy.impl.CustomerStrategyFactory;
import com.sisga.core.factory.strategy.impl.EmployeeHistoryStrategyFactory;
import com.sisga.core.factory.strategy.impl.EmployeeStrategyFactory;
import com.sisga.core.factory.strategy.impl.ProductHistoryStrategyFactory;
import com.sisga.core.factory.strategy.impl.ProductStrategyFactory;
import com.sisga.core.factory.strategy.impl.ProviderHistoryStrategyFactory;
import com.sisga.core.factory.strategy.impl.ProviderStrategyFactory;
import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.provider.Provider;

public class FactoryStrategy {

	private static List < IEntityStrategyFactory > factoryList = new ArrayList<>();
	/**
	 * Mapa para conter as regras de negócio de todas operações por entidade;
	 * O valor é um mapa que de regras de negócio indexado pela operação A
	 * Chave é o nome da entidade referente às regras de negóio e o valor é
	 * um mapa contendo todos os Strategies referentes a cada operação
	 * (salvar,alterar,consultar,excluir)
	 */
	private static Map < String, Map < String, List < IStrategy > > > rns;

	public static List < IStrategy > build( AbstractDomainEntity entity, String operation ) {
		if( rns == null ) {
			initRules();
		}
		List < IStrategy > operationRules = new ArrayList<>();
		Map < String, List < IStrategy > > entityRules = rns.get( entity.getClass().getName() );
		if( entityRules != null ) {
			operationRules = entityRules.get( operation );
		}
		return operationRules;
	}

	private static void initRules() {
		rns = new HashMap < String, Map < String, List < IStrategy > > >();
		factoryList.add( new ProductStrategyFactory() );
		factoryList.add( new ProductHistoryStrategyFactory() );
		factoryList.add( new CustomerStrategyFactory() );
		factoryList.add( new CustomerHistoryStrategyFactory() );
		factoryList.add( new EmployeeStrategyFactory() );
		factoryList.add( new EmployeeHistoryStrategyFactory() );
		factoryList.add( new ProviderStrategyFactory() );
		factoryList.add( new ProviderHistoryStrategyFactory() );

		for( IEntityStrategyFactory factoryStrategy: factoryList ) {
			rns.putAll( factoryStrategy.buildEntityRules() );
		}

	}

	public static void main( String[] args ) {
		List < IStrategy > strategyList = FactoryStrategy.build( new Provider(), EOperation.SAVE );
		for( IStrategy iStrategy: strategyList ) {
			System.out.println( iStrategy );
		}
	}
}
