package com.sisga.core.business.complement;

import java.util.Calendar;

import com.sisga.core.core.business.Complementor;
import com.sisga.core.core.util.Message;
import com.sisga.core.dao.impl.CustomerOperationDAO;
import com.sisga.core.hibernate.SessionThreadLocal;
import com.sisga.domain.address.Address;
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
	public String complement( CustomerHistory customerHistory ) {
		msg = null;

		CustomerHistoryFilter filter = new CustomerHistoryFilter();
		filter.setCode( customerHistory.getCode() );

		try {
			createHistory( customerHistory, customerHistory.getOperationCode() );
		} catch( Exception e ) {
			e.printStackTrace();
			msg = Message.getMessage( "com.sisga.core.unexpected.error", Message.ERROR, customerHistory );
		}

		return msg;
	}

	private void createHistory( CustomerHistory history, String operationCode ) throws Exception {
		Customer customer = history.getCustomer();

		history.setAddress( new Address() );
		history.setActive( customer.isActive() );
		history.getAddress().setCity( customer.getAddress().getCity() );
		history.setCode( customer.getCode() );
		history.setDescription( customer.getDescription() );
		history.setInsertDate( Calendar.getInstance() );
		history.setFirstName( customer.getFirstName() );
		history.setLastName( customer.getLastName() );
		history.getAddress().setNeighborhood( customer.getAddress().getNeighborhood() );
		history.getAddress().setNumber( customer.getAddress().getNumber() );
		history.setEmail( customer.getEmail() );

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