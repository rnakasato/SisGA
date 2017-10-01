package com.sisga.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.user.User;
import com.sisga.domain.user.filter.UserFilter;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         1 de out de 2017
 */
public class UserDAO extends AbstractDAO < User > {

	public UserDAO() {
		super( User.class );
	}

	@Override
	public List < User > find( AbstractDomainEntity entity ) throws Exception {
		UserFilter filter = ( UserFilter ) entity;

		List < User > userList = null;

		Query query = null;

		if( filter.getIsLogin() != null && filter.getIsLogin() ) {
			query = buildLoginFindQuery( filter );
		} else {
			query = buildFindQuery( filter );
		}

		if( query != null ) {
			userList = query.getResultList();
		}
		return userList;
	}

	private Query buildFindQuery( UserFilter filter ) {
		StringBuilder sql = new StringBuilder();
		sql.append( " SELECT u FROM User u " );
		sql.append( " LEFT JOIN u.userType t" );
		sql.append( " WHERE 1=1 " );

		if( filter.getActive() != null ) {
			sql.append( " AND u.active = :active " );
		}

		if( StringUtils.isNotEmpty( filter.getCpf() ) ) {
			sql.append( " AND UPPER(u.cpf) like :cpf " );
		}

		if( StringUtils.isNotEmpty( filter.getRg() ) ) {
			sql.append( " AND UPPER(u.rg) like :rg " );
		}

		if( StringUtils.isNotEmpty( filter.getUsername() ) ) {
			sql.append( " AND UPPER(u.username) like :username " );
		}

		if( StringUtils.isNotEmpty( filter.getFirstName() ) ) {
			sql.append( " AND UPPER(u.firstName) like :firstName " );
		}

		if( StringUtils.isNotEmpty( filter.getLastName() ) ) {
			sql.append( " AND UPPER(u.lastName) like :lastName " );
		}

		if( StringUtils.isNotEmpty( filter.getEmail() ) ) {
			sql.append( " AND UPPER(u.email) like :email " );
		}

		if( filter.getUserType() != null && StringUtils.isNotEmpty( filter.getUserType().getCode() ) ) {
			sql.append( " AND UPPER(t.code) like :userTypeCode " );
		}
		
		Query query = session.createQuery( sql.toString() );
		
		if( filter.getActive() != null ) {
			query.setParameter( "active", filter.getActive() );
		}

		if( StringUtils.isNotEmpty( filter.getCpf() ) ) {
			query.setParameter( "cpf", "%" + filter.getCpf() + "%");
		}

		if( StringUtils.isNotEmpty( filter.getRg() ) ) {
			query.setParameter( "rg", "%" + filter.getRg() + "%");
		}

		if( StringUtils.isNotEmpty( filter.getUsername() ) ) {
			sql.append( " AND UPPER(u.username) like :username " );
			query.setParameter( "username", "%" + filter.getUsername() + "%");
		}

		if( StringUtils.isNotEmpty( filter.getFirstName() ) ) {
			query.setParameter( "firstName", "%" + filter.getFirstName() + "%");
		}

		if( StringUtils.isNotEmpty( filter.getLastName() ) ) {
			query.setParameter( "lastName", "%" + filter.getLastName() + "%");
		}

		if( StringUtils.isNotEmpty( filter.getEmail() ) ) {
			query.setParameter( "email", "%" + filter.getEmail() + "%");
		}

		if( filter.getUserType() != null && StringUtils.isNotEmpty( filter.getUserType().getCode() ) ) {
			query.setParameter( "userTypeCode", "%" + filter.getUserType().getCode() + "%");
		}
		
		return query;

	}

	private Query buildLoginFindQuery( UserFilter filter ) {
		Query query = null;

		StringBuilder sql = new StringBuilder();
		sql.append( " SELECT u FROM User u " );
		sql.append( " WHERE 1=1 " );

		if( filter.getIsLogin() != null && filter.getIsLogin() ) {
			if( StringUtils.isNotEmpty( filter.getUsername() ) && StringUtils.isNotEmpty( filter.getPassword() ) ) {
				sql.append( " AND u.username = :username " );
				sql.append( " AND u.password = :password " );
				sql.append( " AND u.active = 1 " );

				query = session.createQuery( sql.toString() );

				query.setParameter( "username", filter.getUsername() );
				query.setParameter( "password", filter.getPassword() );

			}
		}

		return query;
	}

}
