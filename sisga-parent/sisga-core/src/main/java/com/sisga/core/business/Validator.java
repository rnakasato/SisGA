package com.sisga.core.business;

import com.sisga.domain.AbstractEntity;

public abstract class Validator<T extends AbstractEntity> extends AbstractStrategy<T>{
	
	@Override
	public String process(T entity) {
		return validate(entity);
	}
	
	public abstract String validate(T entity);
}
