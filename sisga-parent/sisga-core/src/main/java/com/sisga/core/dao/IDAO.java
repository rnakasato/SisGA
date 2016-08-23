package com.sisga.core.dao;

import com.sisga.domain.AbstractEntity;

public interface IDAO<T extends AbstractEntity> {
	public void save(T entity);
	public T find(T entity);
	public void delete(T entity);
	public void update(T entity);
}
