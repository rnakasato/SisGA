package com.sisga.domain.product;

import com.sisga.domain.DomainSpecificEntity;

/**
 * 
 * @author Rafael Hikaru Nakasato 7 de mar de 2017
 */
public class ProductOperation extends DomainSpecificEntity {
	public static final String CADASTRO_PRODUTO = "ADD";
	public static final String ALTERACAO_ESTOQUE = "STK";
	public static final String ALTERACAO_DADOS_PRODUTO = "PRD";	
	public static final String EXCLUSAO_PRODUTO = "DEL";
}
