package com.sisga.domain.expense;

import com.sisga.domain.DomainSpecificEntity;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         7 de mar de 2017
 */
public class ExpenseStatus extends DomainSpecificEntity {
	public static final String PAGO = "PAG";
	public static final String PAGO_PARCIALMENTE = "PAR";
	public static final String NAO_INICIADO = "NIN";
}
