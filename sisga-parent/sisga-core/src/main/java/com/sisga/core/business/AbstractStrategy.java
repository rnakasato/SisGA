package com.sisga.core.business;

import com.sisga.core.IStrategy;
import com.sisga.domain.AbstractEntity;

public abstract class AbstractStrategy<T extends AbstractEntity> implements IStrategy<T>{
	protected String msg;
}
