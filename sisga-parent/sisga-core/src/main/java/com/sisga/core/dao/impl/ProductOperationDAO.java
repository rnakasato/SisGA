package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.sisga.core.hibernate.HibernateUtil;
import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.product.Product;
import com.sisga.domain.product.ProductOperation;
import com.sisga.domain.product.ProductionType;

/**
 * 
 * @author Rafael Hikaru Nakasato 7 de mar de 2017
 */
public class ProductOperationDAO extends DomainSpecificEntityDAO < ProductOperation > {

	@Override
	public List < ProductOperation > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < ProductOperation > findAll() throws Exception {
		List < ProductOperation > operationList = null;
		StringBuilder jpql = new StringBuilder();
		jpql.append( " FROM ProductOperation " );

		Query query = session.createQuery( jpql.toString() );

		operationList = query.getResultList();

		return operationList;

	}

	public static void main( String[] args ) throws Exception {
		ProductOperationDAO dao = new ProductOperationDAO();

		Session session = HibernateUtil.getSessionFactory().openSession();
		dao.setSession( session );

		List < ProductOperation > operationList = dao.findAll();

		session.close();
		for( ProductOperation productOperation: operationList ) {
			System.out.println( productOperation.getDescription() );
		}

		System.exit( 0 );
	}

}
