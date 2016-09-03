package com.sisga.core;

import com.sisga.domain.AbstractEntity;

public interface IStrategy<T extends AbstractEntity> {
	public String process(T entity);
}
