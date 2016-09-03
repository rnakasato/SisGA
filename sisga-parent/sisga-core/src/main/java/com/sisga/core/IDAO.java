package com.sisga.core;

import java.util.List;

import com.sisga.domain.AbstractEntity;

public interface IDAO <T extends AbstractEntity> {
	public void save(T entity) throws Exception;
	public void delete(T entity) throws Exception;
	public void update(T entity) throws Exception;
	public T findById(T entity) throws Exception;
	public List<T> find(T entity) throws Exception;
	public List<T> findAll() throws Exception;

}
