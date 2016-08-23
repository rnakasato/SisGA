package com.sisga.core.dao.impl;

import org.hibernate.Session;

import com.sisga.core.dao.IDAO;
import com.sisga.core.hibernate.HibernateUtil;
import com.sisga.domain.AbstractEntity;

public abstract class AbstractDAO<T extends AbstractEntity> implements IDAO<T> {
	private static Session session;

	@Override
	public void save(T entity) {
		session.save(entity);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T find(T entity) {
		Class clazz = entity.getClass();
		T result = null;
		result = (T) session.find(clazz, entity.getId());
		return result;
	}

	@Override
	public void delete(T entity) {
		session.delete(entity);
	}

	@Override
	public void update(T entity) {
		session.update(entity);
	}

	public void openSession() {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	}

	public void cancelSession() {
		session.getTransaction().rollback();
		session.close();
	}

	public void closeSession() {
		session.getTransaction().commit();
		session.close();
	}

}
