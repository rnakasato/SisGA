package com.sisga.core.business.complement;

import java.util.Date;

import com.sisga.core.core.business.Complementor;
import com.sisga.core.dao.impl.CustomerOperationDAO;
import com.sisga.core.hibernate.SessionThreadLocal;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.customer.CustomerHistory;
import com.sisga.domain.customer.CustomerOperation;
import com.sisga.domain.customer.filter.CustomerHistoryFilter;

/**
 * 
 * @author Sergio Massao Umiji
 *         23 de mar de 2017
 */
public class CustomerHistoryComplementor extends Complementor < CustomerHistory > {

	@Override
	public String complement( CustomerHistory CustomerHistory ) {
		msg = null;
		
		CustomerHistoryFilter filter = new CustomerHistoryFilter();
		filter.setCode( CustomerHistory.getCode() );

		try {
			createHistory( CustomerHistory, CustomerHistory.getOperationCode() );
		} catch( Exception e ) {
			e.printStackTrace();
			msg = "Erro inesperado";
		}

		return msg;
	}

	private void createHistory( CustomerHistory history, String operationCode ) throws Exception {
		Customer customer = history.getCustomer();
		
		history.setActive(customer.isActive());
		history.setCity(customer.getCity());
		history.setCode( customer.getCode() );
		history.setDescription( customer.getDescription() );
		history.setInsertDate( new Date() );
		history.setFirstName(customer.getFirstName() );
		history.setLastName(customer.getLastName() );
		history.setNeighborhood(customer.getNeighborhood() );
		history.setNumber(customer.getNumber() );
		history.setEmail(customer.getEmail());
		
		// Identifica a operação
		CustomerOperationDAO dao = new CustomerOperationDAO();
		dao.setSession( SessionThreadLocal.getSession() );

		CustomerOperation op = new CustomerOperation();
		CustomerOperation operation = null;

		op.setCode( operationCode );
		operation = dao.findByCode( op );

		history.setCustomerOperation( operation );
	}
}