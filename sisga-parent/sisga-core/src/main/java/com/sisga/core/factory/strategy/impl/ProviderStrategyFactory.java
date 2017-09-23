package com.sisga.core.factory.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.core.business.complement.InsertDateComplementor;
import com.sisga.core.business.complement.ProviderActiveComplementor;
import com.sisga.core.business.complement.ProviderCodeComplementor;
import com.sisga.core.business.complement.ProviderPhoneComplementor;
import com.sisga.core.business.fieldsvalidator.ProviderFieldsValidator;
import com.sisga.core.business.fieldsvalidator.ProviderSearchValidator;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.strategy.IEntityStrategyFactory;
import com.sisga.domain.provider.Provider;

/**
 * 
 * @author rafae
 *
 */
public class ProviderStrategyFactory implements IEntityStrategyFactory < Provider > {

	@Override
	public Map < String, Map < String, List < IStrategy > > > buildEntityRules() {
		Map < String, Map < String, List < IStrategy > > > rns = new HashMap <>();

		Map < String, List < IStrategy > > rnsProvider = new HashMap < String, List < IStrategy > >();

		List < IStrategy > rnsSave = new ArrayList <>();
		List < IStrategy > rnsUpdate = new ArrayList <>();
		List < IStrategy > rnsFind = new ArrayList <>();
		List < IStrategy > rnsDelete = new ArrayList <>();

		rnsSave.add( new ProviderActiveComplementor() );
		rnsSave.add( new ProviderCodeComplementor() );
		rnsSave.add( new InsertDateComplementor() );
		rnsSave.add( new ProviderFieldsValidator() );
		rnsSave.add( new ProviderPhoneComplementor() );

		rnsUpdate.add( new ProviderFieldsValidator() );
		rnsUpdate.add( new ProviderPhoneComplementor() );

		rnsFind.add( new ProviderSearchValidator() );

		// Insere as regras de neg�cio por opera��o
		rnsProvider.put( EOperation.SAVE, rnsSave );
		rnsProvider.put( EOperation.UPDATE, rnsUpdate );
		rnsProvider.put( EOperation.DELETE, rnsDelete );
		rnsProvider.put( EOperation.FIND, rnsFind );

		rns.put( Provider.class.getName(), rnsProvider );
		return rns;
	}

}
