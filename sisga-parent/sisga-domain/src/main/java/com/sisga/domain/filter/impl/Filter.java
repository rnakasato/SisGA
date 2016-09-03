package com.sisga.domain.filter.impl;

import com.sisga.domain.AbstractEntity;
import com.sisga.domain.filter.IFilter;

public abstract class Filter<T extends AbstractEntity> implements IFilter<T> {
	private T entity;

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

}
