package com.sisga.core.business.fieldsvalidator;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.core.business.FieldsValidator;
import com.sisga.domain.provider.Provider;

/**
 * 
 * @author Sergio Massao Umiji
 *         23 de mar de 2017
 */
public class ProviderFieldsValidator extends FieldsValidator < Provider > {

	@Override
	public String validate( Provider provider ) {
		super.init();
		if( StringUtils.isEmpty( provider.getCorporateName() ) ) {
			appendMsg( "Nome do Fornecedor" );
		}

		if( StringUtils.isEmpty( provider.getCnpj() ) ) {
			appendMsg( "CNPJ do Funcionário" );
		}

		if( StringUtils.isEmpty( provider.getEmail() ) ) {
			appendMsg( "Email do Fornecedor" );
		}

		if( StringUtils.isEmpty( provider.getNeighborhood() ) ) {
			appendMsg( "Bairro do Fornecedor" );
		}

		if( StringUtils.isEmpty( provider.getNumber() ) ) {
			appendMsg( "Numero do Fornecedor" );
		}
	
		if( provider.getCity() == null ) {
			appendMsg( "Cidade do Fornecedor" );
		}
		if( provider.getTelephones() == null ) {
			appendMsg( "Telefone e Celular do Fornecedor" );
		}
		
		if( provider.getTelephones().get(0).getDdd() == null ) {
			appendMsg( "DDD Telefone do Fornecedor" );
		}
		if( provider.getTelephones().get(0).getPnumber() == null ) {
			appendMsg( "Telefone do Fornecedor" );
		}
		if( provider.getTelephones().get(1).getDdd() == null ) {
			appendMsg( "DDD Celular do Fornecedor" );
		}
		if( provider.getTelephones().get(1).getPnumber() == null ) {
			appendMsg( "Celular do Fornecedor" );
		}
		
		return getMessage();
	}

}
