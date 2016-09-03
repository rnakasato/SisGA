package com.sisga.core.command.impl;

import com.sisga.core.application.Result;
import com.sisga.core.impl.Facade;
import com.sisga.domain.AbstractEntity;

public class CommandFind<T extends AbstractEntity> extends Command<T>{

	@Override
	public Result<T> execute() {
		facade = new Facade<T>();
		return facade.find(entity);
	}
	
}
