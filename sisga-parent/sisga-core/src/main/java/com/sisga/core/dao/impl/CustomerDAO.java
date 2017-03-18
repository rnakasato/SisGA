package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.customer.Customer;
import com.sisga.domain.customer.filter.CustomerFilter;

/**
 * 
 * @author Sergio Massao Umiji 
 * 7 de mar de 2017
 * 17 de mar de 2017  - find
 */
public class CustomerDAO extends DomainSpecificEntityDAO < Customer > {
	private CustomerFilter customerFilter;

	@Override
	public List<Customer> find(AbstractDomainEntity entity) throws Exception {
		customerFilter = (CustomerFilter) entity;
		List < Customer > customerList = null;
		
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " SELECT DISTINCT (c) FROM Customer c" );
			jpql.append( " LEFT JOIN c.city cc " );
			jpql.append( " LEFT JOIN c.userSeller cu " );
			jpql.append( " LEFT JOIN c.cellphone cm " );
			jpql.append( " LEFT JOIN c.telephone ct " );
			jpql.append( " WHERE 1=1 " );
			
			if( StringUtils.isNotEmpty( customerFilter.getName() ) ) {
				jpql.append( " AND c.name = :name " );
			}
			if( customerFilter.getStatus().equals("ATIVO")){
				jpql.append( " AND c.active = true " );
			} else if( customerFilter.getStatus().equals("INATIVO")){
				jpql.append( " AND c.active = false " );
			}
				
			Query query = session.createQuery( jpql.toString() );
			
			if( StringUtils.isNotEmpty( customerFilter.getName() ) ) {
				query.setParameter( "name", customerFilter.getName() );
			}

			customerList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return customerList;
	}

	@Override
	public List < Customer > findAll() throws Exception {
		List < Customer > customerList = null;
		try {
			openSession();

			StringBuilder jpql = new StringBuilder();
			jpql.append( " FROM Customer " );

			Query query = session.createQuery( jpql.toString() );

			customerList = query.getResultList();

			closeSession();
		} catch( RuntimeException e ) {
			cancelSession();
		}
		return customerList;
	}

	

	
}
