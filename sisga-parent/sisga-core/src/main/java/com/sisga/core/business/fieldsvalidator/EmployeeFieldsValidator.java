package com.sisga.core.business.fieldsvalidator;

import org.apache.commons.lang3.StringUtils;

import com.sisga.core.core.business.FieldsValidator;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.employee.Employee;
import com.sisga.domain.product.Product;

/**
 * 
 * @author Sergio Massao Umiji
 *         23 de mar de 2017
 */
public class EmployeeFieldsValidator extends FieldsValidator < Employee > {

	@Override
	public String validate( Employee employee ) {
		super.init();
		if( StringUtils.isEmpty( employee.getFirstName() ) ) {
			appendMsg( "Nome do Funcion�rio" );
		}

		if( StringUtils.isEmpty( employee.getLastName() ) ) {
			appendMsg( "Sobrenome do Funcion�rio" );
			
		} 
		
		
		if( StringUtils.isEmpty( employee.getEmail() ) ) {
			appendMsg( "Email do Funcion�rio" );
		} else {
			String email = employee.getEmail().toUpperCase();
			String[] emailSplit01 = email.split("@");
			if (emailSplit01.length == 2) {
				if (emailSplit01[0].length() > 0) {
					if (emailSplit01[1].length() > 2) {
						String com = emailSplit01[1];
						String[] emailSplit02 = com.split(".CO");
						if (emailSplit02.length > 1) {
							
						} else {
							appendMsg("Email Inv�lido");
						}
					} else {
						appendMsg("Email Inv�lido");
					}
				} else {
					appendMsg("Email Inv�lido");
				}
			} else {
				appendMsg("Email Inv�lido");
			}
		}


		if( StringUtils.isEmpty( employee.getNeighborhood() ) ) {
			appendMsg( "Bairro do Funcion�rio" );
		}

		if( StringUtils.isEmpty( employee.getNumber() ) ) {
			appendMsg( "Numero do Funcion�rioe" );
		}
		
		if( StringUtils.isEmpty( employee.getWorkcardNumber()  ) ) {
			appendMsg( "Carteira de Trabalho do Funcion�rioe" );
		}

		if( employee.getCity() == null ) {
			appendMsg( "Cidade do Funcion�rio" );
		}

		if( employee.getEmploymentDate() == null ) {
			appendMsg( "Data de Contrata��o do Funcion�rio" );
		}
		

		if( employee.getTelephones() == null ) {
			appendMsg( "Telefone e Celular do Funcion�rio" );
		}
		
		if( employee.getTelephones().get(0).getDdd() == null ) {
			appendMsg( "DDD Telefone do Funcion�rio" );
		}
		if( employee.getTelephones().get(0).getPnumber() == null ) {
			appendMsg( "Telefone do Funcion�rio" );
		}
		if( employee.getTelephones().get(1).getDdd() == null ) {
			appendMsg( "DDD Celular do Funcion�rio" );
		}
		if( employee.getTelephones().get(1).getPnumber() == null ) {
			appendMsg( "Celular do Funcion�rio" );
		}
		
		return getMessage();
	}

}
