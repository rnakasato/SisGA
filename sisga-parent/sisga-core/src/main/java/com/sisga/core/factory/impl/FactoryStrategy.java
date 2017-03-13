package com.sisga.core.factory.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.core.enums.EOperation;
import com.sisga.domain.AbstractDomainEntity;

public class FactoryStrategy {

	/**
	 * Mapa para conter as regras de neg√≥cio de todas opera√ß√µes por entidade; O
	 * valor √© um mapa que de regras de neg√≥cio indexado pela opera√ß√£o A Chave √©
	 * o nome da entidade referente √†s regras de neg√≥io e o valor √© um mapa
	 * contendo todos os Strategies referentes a cada opera√ß√£o
	 * (salvar,alterar,consultar,excluir)
	 */
	private static Map < String, Map < String, List < IStrategy > > > rns;
	private static Map < String, List < IStrategy > > rnsProduct;
	private static Map < String, List < IStrategy > > rnsCustomer;
	private static Map < String, List < IStrategy > > rnsEmployee;
	private static Map < String, List < IStrategy > > rnsProvider;

	public static List < IStrategy > build( AbstractDomainEntity entity, String operation ) {
		if( rns == null ) {
			initMap();
		}
		List < IStrategy > operationRules = new ArrayList<>();
		Map < String, List < IStrategy > > entityRules = rns.get( entity.getClass().getName() );
		if( entityRules != null ) {
			operationRules = entityRules.get( operation );
		}
		return operationRules;
	}

	private static void initMap() {
		// inicializa√ß√£o do mapa de regras de neg√≥cio total
		rns = new HashMap<>();

		// Inicializa√ß√£o do mapa de regras de neg√≥cio do produto
		rnsProduct = new HashMap<>();
		initProductRns();
		
		// InicializaÁ„o do mapa de regras de negÛcio do cliente
		rnsCustomer = new HashMap<>();
		initCustomerRns();
		
		// InicializaÁ„o do mapa de regras de negÛcio do funcionario
		rnsEmployee = new HashMap<>();
		initEmployeeRns();
			
		// InicializaÁ„o do mapa de regras de negÛcio do fornecedor
		rnsProvider = new HashMap<>();
		initProviderRns();


	}

	private static void initProductRns() {
		List < IStrategy > rnsSave = new ArrayList<>();
		List < IStrategy > rnsUpdate = new ArrayList<>();
		// N√£o h√° regras para a busca de produto
		List < IStrategy > rnsFind = new ArrayList<>();
		List < IStrategy > rnsDelete = new ArrayList<>();

		// Insere as regras de neg√≥cio por opera√ß√£o
		rnsProduct.put( EOperation.SAVE, rnsSave );
		rnsProduct.put( EOperation.UPDATE, rnsUpdate );
		rnsProduct.put( EOperation.DELETE, rnsDelete );
		rnsProduct.put( EOperation.FIND, rnsFind );
	}
	
	private static void initCustomerRns() {
		List < IStrategy > rnsSave = new ArrayList<>();
		List < IStrategy > rnsUpdate = new ArrayList<>();
		List < IStrategy > rnsFind = new ArrayList<>();
		List < IStrategy > rnsDelete = new ArrayList<>();

		// Insere as regras de negÛcio por operaÁ„o
		rnsCustomer.put( EOperation.SAVE, rnsSave );
		rnsCustomer.put( EOperation.UPDATE, rnsUpdate );
		rnsCustomer.put( EOperation.DELETE, rnsDelete );
		rnsCustomer.put( EOperation.FIND, rnsFind );
	}

	
	private static void initEmployeeRns() {
		List < IStrategy > rnsSave = new ArrayList<>();
		List < IStrategy > rnsUpdate = new ArrayList<>();
		List < IStrategy > rnsFind = new ArrayList<>();
		List < IStrategy > rnsDelete = new ArrayList<>();

		// Insere as regras de negÛcio por operaÁ„o
		rnsEmployee.put( EOperation.SAVE, rnsSave );
		rnsEmployee.put( EOperation.UPDATE, rnsUpdate );
		rnsEmployee.put( EOperation.DELETE, rnsDelete );
		rnsEmployee.put( EOperation.FIND, rnsFind );
	}

	
	private static void initProviderRns() {
		List < IStrategy > rnsSave = new ArrayList<>();
		List < IStrategy > rnsUpdate = new ArrayList<>();
		List < IStrategy > rnsFind = new ArrayList<>();
		List < IStrategy > rnsDelete = new ArrayList<>();

		// Insere as regras de negÛcio por operaÁ„o
		rnsProvider.put( EOperation.SAVE, rnsSave );
		rnsProvider.put( EOperation.UPDATE, rnsUpdate );
		rnsProvider.put( EOperation.DELETE, rnsDelete );
		rnsProvider.put( EOperation.FIND, rnsFind );
	}

}
