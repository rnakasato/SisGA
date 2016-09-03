package com.sisga.core;

import com.sisga.core.application.Result;
import com.sisga.domain.AbstractEntity;
import com.sisga.domain.filter.impl.Filter;

public interface IFacade<T extends AbstractEntity> {
	public Result<T> save(T entity);
	public Result<T> update(T entity);
	public Result<T> delete(T entity);
	public Result<T> find(T entity);
	public Result<T> findAll(T entity);
	public Result<T> view(T entity);
	public Result<T>doRules(T entity, Integer parameter);
}
