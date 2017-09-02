package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.sisga.core.hibernate.HibernateUtil;
import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.customer.filter.CustomerFilter;

/**
 * 
 * @author Sergio Massao Umiji
 *         7 de mar de 2017
 *         17 de mar de 2017 - find
 */
public class CustomerDAO extends DomainSpecificEntityDAO < Customer > {
	private CustomerFilter customerFilter;

	public CustomerDAO() {
		super( Customer.class );
	}

	@Override
	public List < Customer > find( AbstractDomainEntity entity ) throws Exception {
		customerFilter = ( CustomerFilter ) entity;
		List < Customer > customerList = null;

		StringBuilder jpql = new StringBuilder();
		jpql.append( " SELECT DISTINCT (c) FROM Customer c" );
		jpql.append( " LEFT JOIN c.city cc " );
		// jpql.append( " LEFT JOIN c.userSeller cu " ); // Adicionar após
		// cadastro de usuário
		jpql.append( " LEFT JOIN c.telephones ct " );
		jpql.append( " WHERE 1=1 " );

		if( StringUtils.isNotEmpty( customerFilter.getName() ) ) {
			jpql.append( " AND UPPER(c.name) = :name " );
		}

		if( customerFilter.getStatus() != null ) {
			if( customerFilter.getStatus().equals( "ATIVO" ) ) {
				jpql.append( " AND c.active = true " );
			} else if( customerFilter.getStatus().equals( "INATIVO" ) ) {
				jpql.append( " AND c.active = false " );
			}
		}

		Query query = session.createQuery( jpql.toString() );

		if( StringUtils.isNotEmpty( customerFilter.getName() ) ) {
			query.setParameter( "name", customerFilter.getName().toUpperCase() );
		}

		customerList = query.getResultList();

		return customerList;
	}

	public static void main( String[] args ) throws Exception {
		CustomerDAO dao = new CustomerDAO();

		Session session = HibernateUtil.getSessionFactory().openSession();
		dao.setSession( session );

		List < Customer > list = dao.findAll();

		session.close();
		for( Customer domain: list ) {
			System.out.println( domain.getFirstName() );
		}
		System.exit( 0 );
	}

}
