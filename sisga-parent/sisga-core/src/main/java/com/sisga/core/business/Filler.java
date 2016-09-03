package com.sisga.core.business;

import com.sisga.domain.AbstractEntity;

public abstract class Filler<T extends AbstractEntity> extends AbstractStrategy<T>{
	
	@Override
	public String process(T entity) {
		return fill(entity);
	}
	
	public abstract String fill(T entity);
}
