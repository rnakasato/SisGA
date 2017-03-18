package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.sisga.core.ICommand;
import com.sisga.core.application.Result;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.impl.FactoryCommand;
import com.sisga.core.hibernate.HibernateUtil;
import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.product.Product;
import com.sisga.domain.product.ProductionType;

/**
 * 
 * @author Rafael Hikaru Nakasato 7 de mar de 2017
 */
public class ProductionTypeDAO extends DomainSpecificEntityDAO < ProductionType > {

	@Override
	public List < ProductionType > find( AbstractDomainEntity entity ) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List < ProductionType > findAll() throws Exception {
		List < ProductionType > productionTypeList = null;

		StringBuilder jpql = new StringBuilder();
		jpql.append( " FROM ProductionType " );

		Query query = session.createQuery( jpql.toString() );

		productionTypeList = query.getResultList();

		return productionTypeList;

	}

	public static void main( String[] args ) throws ClassNotFoundException {
		try {

			ProductionTypeDAO dao = new ProductionTypeDAO();

			Session session = HibernateUtil.getSessionFactory().openSession();
			dao.setSession( session );

			ProductionType p = new ProductionType();
			p.setCode( "SEM" );
			p = dao.findByCode( p );

			session.close();
			System.out.println( p.getDescription() );
		} catch( Exception e ) {

		} finally {

			System.exit( 0 );

		}

	}
}
