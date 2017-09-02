package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.sisga.core.hibernate.HibernateUtil;
import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.address.City;

/**
 * 
 * @author Sergio Massao Umiji
 *         26 de mar de 2017 - find
 */
public class CityDAO extends DomainSpecificEntityDAO < City > {

	private City city;

	public CityDAO() {
		super( City.class );
	}

	@Override
	public List < City > find( AbstractDomainEntity entity ) throws Exception {
		List < City > cityList = null;
		city = ( City ) entity;

		StringBuilder jpql = new StringBuilder();
		jpql.append( " FROM City " );

		if( StringUtils.isNotEmpty( city.getUf() ) ) {
			jpql.append( " WHERE UF = :uf " );
		}
		Query query = session.createQuery( jpql.toString() );

		if( StringUtils.isNotEmpty( city.getUf() ) ) {
			query.setParameter( "uf", city.getUf() );
		}

		cityList = query.getResultList();

		return cityList;
	}

	public static void main( String[] args ) throws Exception {
		CityDAO dao = new CityDAO();

		Session session = HibernateUtil.getSessionFactory().openSession();
		dao.setSession( session );

		List < City > list = dao.findAll();

		session.close();
		for( City domain: list ) {
			System.out.println( domain.getName() );
		}

		System.exit( 0 );
	}

}
