package com.sisga.core.factory.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.core.business.complement.InsertDateComplementor;
import com.sisga.core.business.complement.ProductActiveComplementor;
import com.sisga.core.business.complement.ProductCodeComplementor;
import com.sisga.core.business.complement.ProductSaleTypeComplementor;
import com.sisga.core.business.fieldsvalidator.ProductFieldsValidator;
import com.sisga.core.business.validator.ProductAmountValidator;
import com.sisga.core.business.validator.ProductBaseValueValidator;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.strategy.IEntityStrategyFactory;
import com.sisga.domain.product.Product;

/**
 * 
 * @author rafae
 *
 */
public class ProductStrategyFactory implements IEntityStrategyFactory < Product > {

	@Override
	public Map < String, Map < String, List < IStrategy > > > buildEntityRules() {
		Map < String, Map < String, List < IStrategy > > > rns = new HashMap<>();

		Map < String, List < IStrategy > > rnsProduct = new HashMap<>();

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

		rns.put( Product.class.getName(), rnsProduct );
		return rns;
	}

}
