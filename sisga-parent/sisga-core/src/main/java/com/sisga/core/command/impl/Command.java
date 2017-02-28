package com.sisga.core.command.impl;

import com.sisga.core.ICommand;
import com.sisga.core.IFacade;
import com.sisga.domain.AbstractDomainEntity;

public abstract class Command < T extends AbstractDomainEntity > implements ICommand < T > {
	protected IFacade facade;
	protected AbstractDomainEntity entity;
	protected Integer parameter;

	public IFacade getFacade() {
		return facade;
	}

	public void setFacade( IFacade facade ) {
		this.facade = facade;
	}

	public AbstractDomainEntity getEntity() {
		return entity;
	}

	public void setEntity( AbstractDomainEntity entity ) {
		this.entity = entity;
	}

	public Integer getParameter() {
		return parameter;
	}

	public void setParameter( Integer parameter ) {
		this.parameter = parameter;
	}

}
