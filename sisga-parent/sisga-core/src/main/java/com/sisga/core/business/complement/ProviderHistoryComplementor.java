package com.sisga.core.business.complement;

import java.util.Calendar;

import com.sisga.core.core.business.Complementor;
import com.sisga.core.core.util.Message;
import com.sisga.core.dao.impl.ProviderOperationDAO;
import com.sisga.core.hibernate.SessionThreadLocal;
import com.sisga.domain.address.Address;
import com.sisga.domain.provider.Provider;
import com.sisga.domain.provider.ProviderHistory;
import com.sisga.domain.provider.ProviderOperation;
import com.sisga.domain.provider.filter.ProviderHistoryFilter;

/**
 * 
 * @author Sergio Massao Umiji
 *         23 de mar de 2017
 */
public class ProviderHistoryComplementor extends Complementor < ProviderHistory > {

	@Override
	public String complement( ProviderHistory providerHistory ) {
		msg = null;

		ProviderHistoryFilter filter = new ProviderHistoryFilter();
		filter.setCode( providerHistory.getCode() );

		try {
			createHistory( providerHistory, providerHistory.getOperationCode() );
		} catch( Exception e ) {
			e.printStackTrace();
			msg = Message.getMessage( "com.sisga.core.unexpected.error", Message.ERROR, providerHistory );
		}

		return msg;
	}

	private void createHistory( ProviderHistory history, String operationCode ) throws Exception {
		Provider provider = history.getProvider();

		history.setAddress( new Address() );
		history.setActive( provider.getActive() );
		history.getAddress().setCity( provider.getAddress().getCity() );
		history.setCode( provider.getCode() );
		history.setDescription( provider.getDescription() );
		history.setInsertDate( Calendar.getInstance() );
		history.setCorporateName( provider.getCorporateName() );
		history.setCnpj( provider.getCnpj() );
		history.getAddress().setNeighborhood( provider.getAddress().getNeighborhood() );
		history.getAddress().setNumber( provider.getAddress().getNumber() );
		history.setEmail( provider.getEmail() );

		// Identifica a operação
		ProviderOperationDAO dao = new ProviderOperationDAO();
		dao.setSession( SessionThreadLocal.getSession() );

		ProviderOperation op = new ProviderOperation();
		ProviderOperation operation = null;

		op.setCode( operationCode );
		operation = dao.findByCode( op );

		history.setProviderOperation( operation );
	}
}