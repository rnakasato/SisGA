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
	 * Mapa para conter as regras de negócio de todas operações por entidade; O
	 * valor é um mapa que de regras de negócio indexado pela operação A Chave é
	 * o nome da entidade referente às regras de negóio e o valor é um mapa
	 * contendo todos os Strategies referentes a cada operação
	 * (salvar,alterar,consultar,excluir)
	 */
	private static Map < String, Map < String, List < IStrategy > > > rns;
	private static Map < String, List < IStrategy > > rnsProduct;

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
		// inicialização do mapa de regras de negócio total
		rns = new HashMap<>();

		// Inicialização do mapa de regras de negócio do produto
		rnsProduct = new HashMap<>();
		initProductRns();

	}

	private static void initProductRns() {
		List < IStrategy > rnsSave = new ArrayList<>();
		List < IStrategy > rnsUpdate = new ArrayList<>();
		// Não há regras para a busca de produto
		List < IStrategy > rnsFind = new ArrayList<>();
		List < IStrategy > rnsDelete = new ArrayList<>();

		// Insere as regras de negócio por operação
		rnsProduct.put( EOperation.SAVE, rnsSave );
		rnsProduct.put( EOperation.UPDATE, rnsUpdate );
		rnsProduct.put( EOperation.DELETE, rnsDelete );
		rnsProduct.put( EOperation.FIND, rnsFind );
	}
}
