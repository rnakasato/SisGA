package com.sisga.core.command.impl;

import com.sisga.core.ICommand;
import com.sisga.core.IFacade;
import com.sisga.domain.AbstractEntity;

public abstract class Command<T extends AbstractEntity> implements ICommand<T>{
	protected IFacade facade;
	protected AbstractEntity entity;
	protected Integer parameter;

	public IFacade getFacade() {
		return facade;
	}

	public void setFacade(IFacade facade) {
		this.facade = facade;
	}

	public AbstractEntity getEntity() {
		return entity;
	}

	public void setEntity(AbstractEntity entity) {
		this.entity = entity;
	}

	public Integer getParameter() {
		return parameter;
	}

	public void setParameter(Integer parameter) {
		this.parameter = parameter;
	}
		
}
