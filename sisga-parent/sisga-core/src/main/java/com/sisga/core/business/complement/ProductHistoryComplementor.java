package com.sisga.core.business.complement;

import java.util.Date;

import com.sisga.core.core.business.Complementor;
import com.sisga.core.core.util.Message;
import com.sisga.core.dao.impl.ProductOperationDAO;
import com.sisga.core.hibernate.SessionThreadLocal;
import com.sisga.domain.product.Product;
import com.sisga.domain.product.ProductHistory;
import com.sisga.domain.product.ProductOperation;
import com.sisga.domain.product.filter.ProductHistoryFilter;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         19 de mar de 2017
 */
public class ProductHistoryComplementor extends Complementor < ProductHistory > {

	@Override
	public String complement( ProductHistory productHistory ) {
		msg = null;
		ProductHistoryFilter filter = new ProductHistoryFilter();
		filter.setCode( productHistory.getCode() );

		try {
			createHistory( productHistory, productHistory.getOperationCode() );
		} catch( Exception e ) {
			e.printStackTrace();
			msg = Message.getMessage( "com.sisga.core.unexpected.error", Message.ERROR, productHistory );
		}

		return msg;
	}

	private void createHistory( ProductHistory history, String operationCode ) throws Exception {
		Product product = history.getProduct();

		history.setAmount( product.getAmount() );
		history.setBaseValue( product.getBaseValue() );
		history.setCode( product.getCode() );
		history.setDescription( product.getDescription() );
		history.setInsertDate( new Date() );
		history.setPhoto( product.getPhoto() );
		history.setProductionType( product.getProductionType() );
		history.setSaleType( product.getSaleType() );
		history.setStockType( product.getStockType() );

		// Identifica a operação
		ProductOperationDAO dao = new ProductOperationDAO();
		dao.setSession( SessionThreadLocal.getSession() );

		ProductOperation op = new ProductOperation();
		ProductOperation operation = null;

		op.setCode( operationCode );
		operation = dao.findByCode( op );

		history.setProductOperation( operation );

	}

}
