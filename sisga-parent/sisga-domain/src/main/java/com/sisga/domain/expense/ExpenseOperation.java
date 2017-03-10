package com.sisga.domain.expense;

import com.sisga.domain.DomainSpecificEntity;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         7 de mar de 2017
 */
public class ExpenseOperation extends DomainSpecificEntity {
	public static final String CADASTRO_DESPESA = "ADD";
	public static final String ALTERACAO_DESPESA = "ALT";
	public static final String EXCLUSAO_DESPESA = "DEL";

}
