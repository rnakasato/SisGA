package com.sisga.core.business.complement;

import com.sisga.core.core.business.Complementor;
import com.sisga.domain.provider.Provider;

public class ProviderPhoneComplementor extends Complementor < Provider > {

	@Override
	public String complement( Provider entity ) {
		if( ! entity.getTelephones().isEmpty() ) {
			entity.getTelephones().get( 0 ).setProvider( entity );
			entity.getTelephones().get( 1 ).setProvider( entity );
			return null;
		}
		return( "Numeros de Telefones não informados" );
	}

}
