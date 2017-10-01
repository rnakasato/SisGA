package com.sisga.core.factory.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.core.business.complement.UserLoginComplemmentor;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.strategy.IEntityStrategyFactory;
import com.sisga.domain.product.Product;
import com.sisga.domain.user.User;

/**
 * 
 * @author Rafael Hikaru Nakasato
 * 1 de out de 2017
 */
public class UserStrategyFactory implements IEntityStrategyFactory < User >{

	@Override
	public Map < String, Map < String, List < IStrategy > > > buildEntityRules() {
		
		Map < String, Map < String, List < IStrategy > > > rns = new HashMap <>();

		Map < String, List < IStrategy > > rnsProduct = new HashMap <>();

		List < IStrategy > rnsSave = new ArrayList <>();
		List < IStrategy > rnsUpdate = new ArrayList <>();
		// Não há regras para a busca de produto
		List < IStrategy > rnsFind = new ArrayList <>();
		List < IStrategy > rnsDelete = new ArrayList <>();

		// rnsSave.add( new ProductFieldsValidator() );
		
		// rnsUpdate.add( new ProductFieldsValidator() );
		
		rnsFind.add( new UserLoginComplemmentor() );
		
		
		// Insere as regras de negócio por operação
		rnsProduct.put( EOperation.SAVE, rnsSave );
		rnsProduct.put( EOperation.UPDATE, rnsUpdate );
		rnsProduct.put( EOperation.DELETE, rnsDelete );
		rnsProduct.put( EOperation.FIND, rnsFind );

		rns.put( Product.class.getName(), rnsProduct );
		return rns;
	}

}
