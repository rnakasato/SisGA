package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.sisga.core.hibernate.HibernateUtil;
import com.sisga.domain.product.ProductOperation;
import com.sisga.domain.provider.Provider;

/**
 * 
 * @author Sergio Massao Umiji 7 de mar de 2017
 */
public class ProviderDAO extends DomainSpecificEntityDAO < Provider > {

	@Override
	public List < Provider > find( Provider fornecedor ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < Provider > findAll() throws Exception {
		List < Provider > providerList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM Provider " );

			Query query = session.createQuery( jpql.toString() );

			providerList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return providerList;
	}
	
	public static void main( String[] args ) throws Exception {
		ProviderDAO dao = new ProviderDAO();

		Session session = HibernateUtil.getSessionFactory().openSession();
		dao.setSession( session );

		List<Provider> providerList = dao.findAll();

		session.close();
		for( Provider provider: providerList ) {
			System.out.println( provider.getDescription() );
		}

		System.exit( 0 );
	}

}
