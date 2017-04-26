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
			appendMsg( "Nome do Funcionário" );
		}

		if( StringUtils.isEmpty( employee.getLastName() ) ) {
			appendMsg( "Sobrenome do Funcionário" );
			
		} 
		
		
		if( StringUtils.isEmpty( employee.getEmail() ) ) {
			appendMsg( "Email do Funcionário" );
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
							appendMsg("Email Inválido");
						}
					} else {
						appendMsg("Email Inválido");
					}
				} else {
					appendMsg("Email Inválido");
				}
			} else {
				appendMsg("Email Inválido");
			}
		}


		if( StringUtils.isEmpty( employee.getNeighborhood() ) ) {
			appendMsg( "Bairro do Funcionário" );
		}

		if( StringUtils.isEmpty( employee.getNumber() ) ) {
			appendMsg( "Numero do Funcionárioe" );
		}
		
		if( StringUtils.isEmpty( employee.getWorkcardNumber()  ) ) {
			appendMsg( "Carteira de Trabalho do Funcionárioe" );
		}

		if( employee.getCity() == null ) {
			appendMsg( "Cidade do Funcionário" );
		}

		if( employee.getEmploymentDate() == null ) {
			appendMsg( "Data de Contratação do Funcionário" );
		}
		

		if( employee.getTelephones() == null ) {
			appendMsg( "Telefone e Celular do Funcionário" );
		}
		
		if( employee.getTelephones().get(0).getDdd() == null ) {
			appendMsg( "DDD Telefone do Funcionário" );
		}
		if( employee.getTelephones().get(0).getPnumber() == null ) {
			appendMsg( "Telefone do Funcionário" );
		}
		if( employee.getTelephones().get(1).getDdd() == null ) {
			appendMsg( "DDD Celular do Funcionário" );
		}
		if( employee.getTelephones().get(1).getPnumber() == null ) {
			appendMsg( "Celular do Funcionário" );
		}
		
		return getMessage();
	}

}
