package com.sisga.core.factory.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.core.business.complement.InsertDateComplementor;
import com.sisga.core.business.complement.ProductActiveComplementor;
import com.sisga.core.business.complement.ProductCodeComplementor;
import com.sisga.core.business.complement.ProductHistoryComplementor;
import com.sisga.core.business.complement.ProductSaleTypeComplementor;
import com.sisga.core.business.fieldsvalidator.ProductFieldsValidator;
import com.sisga.core.business.validator.ProductAmountValidator;
import com.sisga.core.business.validator.ProductBaseValueValidator;
import com.sisga.core.enums.EOperation;
import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.product.Product;
import com.sisga.domain.product.ProductHistory;

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
	private static Map < String, List < IStrategy > > rnsProductHistory;
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
		// inicialização do mapa de regras de negócio total
		rns = new HashMap<>();

		// Inicialização do mapa de regras de negócio do produto
		rnsProduct = new HashMap<>();
		initProductRns();
		
		// Inicialização do mapa de regras de histórico de produto
		rnsProductHistory = new HashMap<>();
		initProductHistoryRns();

		// Inicializa��o do mapa de regras de neg�cio do cliente
		rnsCustomer = new HashMap<>();
		initCustomerRns();

		// Inicializa��o do mapa de regras de neg�cio do funcionario
		rnsEmployee = new HashMap<>();
		initEmployeeRns();

		// Inicializa��o do mapa de regras de neg�cio do fornecedor
		rnsProvider = new HashMap<>();
		initProviderRns();
		
		// Adiciona regras de negócio no mapa
		rns.put( Product.class.getName(), rnsProduct );
		rns.put( ProductHistory.class.getName(), rnsProductHistory );

	}

	private static void initProductRns() {
		List < IStrategy > rnsSave = new ArrayList<>();
		List < IStrategy > rnsUpdate = new ArrayList<>();
		// Não há regras para a busca de produto
		List < IStrategy > rnsFind = new ArrayList<>();
		List < IStrategy > rnsDelete = new ArrayList<>();

		rnsSave.add( new ProductFieldsValidator() );
		rnsSave.add( new ProductAmountValidator() );
		rnsSave.add( new ProductBaseValueValidator() );
		rnsSave.add( new ProductSaleTypeComplementor() );
		rnsSave.add( new InsertDateComplementor() );
		rnsSave.add( new ProductActiveComplementor() );		
		rnsSave.add( new ProductCodeComplementor() );

		rnsUpdate.add( new ProductFieldsValidator() );
		rnsUpdate.add( new ProductAmountValidator() );
		rnsUpdate.add( new ProductBaseValueValidator() );
		rnsUpdate.add( new ProductSaleTypeComplementor() );

		// Insere as regras de negócio por operação
		rnsProduct.put( EOperation.SAVE, rnsSave );
		rnsProduct.put( EOperation.UPDATE, rnsUpdate );
		rnsProduct.put( EOperation.DELETE, rnsDelete );
		rnsProduct.put( EOperation.FIND, rnsFind );
	}
	
	
	private static void initProductHistoryRns() {
		List < IStrategy > rnsSave = new ArrayList<>();
		List < IStrategy > rnsUpdate = new ArrayList<>();
		// Não há regras para a busca de produto
		List < IStrategy > rnsFind = new ArrayList<>();
		List < IStrategy > rnsDelete = new ArrayList<>();

		rnsSave.add( new ProductHistoryComplementor() );

		// Insere as regras de negócio por operação
		rnsProductHistory.put( EOperation.SAVE, rnsSave );
		rnsProductHistory.put( EOperation.UPDATE, rnsUpdate );
		rnsProductHistory.put( EOperation.DELETE, rnsDelete );
		rnsProductHistory.put( EOperation.FIND, rnsFind );
	}

	
	private static void initCustomerRns() {
		List < IStrategy > rnsSave = new ArrayList<>();
		List < IStrategy > rnsUpdate = new ArrayList<>();
		List < IStrategy > rnsFind = new ArrayList<>();
		List < IStrategy > rnsDelete = new ArrayList<>();

		// Insere as regras de neg�cio por opera��o
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

		// Insere as regras de neg�cio por opera��o
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

		// Insere as regras de neg�cio por opera��o
		rnsProvider.put( EOperation.SAVE, rnsSave );
		rnsProvider.put( EOperation.UPDATE, rnsUpdate );
		rnsProvider.put( EOperation.DELETE, rnsDelete );
		rnsProvider.put( EOperation.FIND, rnsFind );
	}

}
