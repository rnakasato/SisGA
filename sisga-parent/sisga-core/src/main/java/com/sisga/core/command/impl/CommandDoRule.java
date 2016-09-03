package com.sisga.core.command.impl;

import com.sisga.core.application.Result;
import com.sisga.core.impl.Facade;
import com.sisga.domain.AbstractEntity;

public class CommandDoRule<T extends AbstractEntity> extends Command<T>{
			
	@Override
	public Result<T> execute() {
		Result<T> result = null;
		if(parameter != null){
			facade = new Facade<T>();
			result = facade.doRules(entity, parameter);
		}
		return result;
	}
	
}
