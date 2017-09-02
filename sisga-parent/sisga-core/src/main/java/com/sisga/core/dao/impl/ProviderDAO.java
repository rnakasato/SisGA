package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.sisga.core.hibernate.HibernateUtil;
import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.provider.Provider;
import com.sisga.domain.provider.filter.ProviderFilter;

/**
 * 
 * @author Sergio Massao Umiji 7 de mar de 2017
 */
public class ProviderDAO extends AbstractDAO < Provider > {
	public ProviderDAO() {
		super( Provider.class );
	}

	private ProviderFilter providerFilter;

	@Override
	public List < Provider > find( AbstractDomainEntity entity ) throws Exception {
		providerFilter = ( ProviderFilter ) entity;
		List < Provider > providerList = null;

		StringBuilder jpql = new StringBuilder();
		jpql.append( " SELECT DISTINCT (p) FROM Provider p" );
		jpql.append( " LEFT JOIN p.city pc " );
		jpql.append( " LEFT JOIN p.telephones pt " );
		jpql.append( " WHERE 1=1 " );

		if( StringUtils.isNotEmpty( providerFilter.getName() ) ) {
			jpql.append( " AND (UPPER(p.corporatename) LIKE :name) " );
		}
		if( providerFilter.getStatus().equals( "ATIVO" ) ) {
			jpql.append( " AND p.active = true " );
		} else if( providerFilter.getStatus().equals( "INATIVO" ) ) {
			jpql.append( " AND p.active = false " );
		}
		Query query = session.createQuery( jpql.toString() );

		if( StringUtils.isNotEmpty( providerFilter.getName() ) ) {
			query.setParameter( "name", "%" + providerFilter.getName().toUpperCase() + "%" );
		}

		providerList = query.getResultList();

		return providerList;
	}

	public static void main( String[] args ) throws Exception {
		ProviderDAO dao = new ProviderDAO();

		Session session = HibernateUtil.getSessionFactory().openSession();
		dao.setSession( session );

		List < Provider > providerList = dao.findAll();

		session.close();
		for( Provider provider: providerList ) {
			System.out.println( provider.getCorporateName() );
		}

		System.exit( 0 );
	}

}
