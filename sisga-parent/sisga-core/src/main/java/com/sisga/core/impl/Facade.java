package com.sisga.core.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.sisga.core.IDAO;
import com.sisga.core.IFacade;
import com.sisga.core.IStrategy;
import com.sisga.core.application.Result;
import com.sisga.core.core.util.Message;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.impl.FactoryDAO;
import com.sisga.core.factory.impl.FactoryStrategy;
import com.sisga.core.hibernate.SessionThreadLocal;
import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.EntityCarrier;

public class Facade < T extends AbstractDomainEntity > implements IFacade < T > {

	private Result result;

	public Facade() {

	}
	
	public static Facade getInstance() {
		return new Facade();
	}

	@Override
	public Result < T > save( T entity ) {
		Result < T > result = new Result < T >();
		String nmClasse = entity.getClass().getName();

		String msg = runRules( entity, EOperation.SAVE );

		if( msg == null ) {

			try {
				Session session = SessionThreadLocal.getSession();
				IDAO dao = FactoryDAO.build( nmClasse, session );
				dao.save( entity );
				List < T > entityList = new ArrayList < T >();
				entityList.add( entity );
				result.setEntityList( entityList );
				SessionThreadLocal.commit();
			} catch( Exception e ) {
				SessionThreadLocal.rollback();
				e.printStackTrace();
				result.setMsg( Message.getMessage( "com.sisga.core.impl.facade.save.error", Message.ERROR, entity ) );
			} finally {
				SessionThreadLocal.closeSession();
			}
		} else {
			result.setMsg( msg );
		}

		return result;
	}

	@Override
	public Result < T > update( T entity ) {
		Result < T > result = new Result < T >();
		String nmClasse = entity.getClass().getName();

		String msg = runRules( entity, EOperation.UPDATE );

		if( msg == null ) {

			try {
				Session session = SessionThreadLocal.getSession();
				IDAO dao = FactoryDAO.build( nmClasse, session );
				dao.update( entity );
				List < T > entityList = new ArrayList < T >();
				entityList.add( entity );
				result.setEntityList( entityList );
				SessionThreadLocal.commit();
			} catch( Exception e ) {
				e.printStackTrace();
				result.setMsg( Message.getMessage( "com.sisga.core.impl.facade.update.error", Message.ERROR, entity ) );
			} finally {
				SessionThreadLocal.closeSession();
			}
		} else {
			result.setMsg( msg );
		}

		return result;

	}

	@Override
	public Result < T > delete( T entity ) {
		Result < T > result = new Result < T >();
		String classNm = entity.getClass().getName();

		String msg = runRules( entity, EOperation.DELETE );

		if( msg == null ) {
			try {
				Session session = SessionThreadLocal.getSession();
				IDAO dao = FactoryDAO.build( classNm, session );
				dao.delete( entity );
				List < T > entityList = new ArrayList < T >();
				entityList.add( entity );
				result.setEntityList( entityList );
				SessionThreadLocal.commit();
			} catch( Exception e ) {
				e.printStackTrace();
				result.setMsg( Message.getMessage( "com.sisga.core.impl.facade.delete.error", Message.ERROR, entity ) );
			} finally {
				SessionThreadLocal.closeSession();
			}
		} else {
			result.setMsg( msg );
		}

		return result;

	}

	@Override
	public Result < T > find( T entity ) {
		Result < T > result = new Result < T >();
		String classNm = entity.getClass().getName();

		String msg = runRules( entity, EOperation.FIND );

		if( msg == null && ! ( entity instanceof EntityCarrier ) ) {
			try {
				Session session = SessionThreadLocal.getSession();
				IDAO dao = FactoryDAO.build( classNm, session );
				result.setEntityList( dao.find( entity ) );
			} catch( Exception e ) {
				e.printStackTrace();
				result.setMsg( Message.getMessage( "com.sisga.core.impl.facade.find.error", Message.ERROR, entity ) );
			} finally {
				SessionThreadLocal.closeSession();
			}
		} else {
			result.setMsg( msg );

		}

		return result;
	}

	public String runRules( T entity, String operation ) {
		StringBuilder msg = null;
		List < IStrategy > rules = FactoryStrategy.build( entity, operation );
		if( rules != null ) {
			msg = new StringBuilder();
			for( IStrategy s: rules ) {
				String m = s.process( entity );
				if( StringUtils.isNotEmpty( m ) ) {
					msg.append( m );
					break;
				}
			}
		}
		String messages = null;
		if( msg != null && msg.length() > 0 ) {
			messages = msg.toString();
		}
		return messages;
	}

	@Override
	public Result < T > findAll( T entity ) {
		Result < T > result = new Result < T >();
		String classNm = entity.getClass().getName();

		String msg = runRules( entity, EOperation.FINDALL );

		if( msg == null ) {
			try {
				Session session = SessionThreadLocal.getSession();
				IDAO dao = FactoryDAO.build( classNm, session );
				result.setEntityList( dao.findAll() );
			} catch( Exception e ) {
				result.setMsg( Message.getMessage( "com.sisga.core.impl.facade.find.error", Message.ERROR, entity ) );
				SessionThreadLocal.rollback();
			} finally {
				SessionThreadLocal.closeSession();
			}
		} else {
			result.setMsg( msg );

		}

		return result;
	}

}
