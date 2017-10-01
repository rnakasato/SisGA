package com.sisga.core.command.impl;

import com.sisga.core.application.Result;
import com.sisga.core.impl.Facade;
import com.sisga.domain.AbstractDomainEntity;

public class CommandFind < T extends AbstractDomainEntity > extends Command < T > {

	@Override
	public Result < T > execute() {
		facade = Facade.getInstance();
		return facade.find( entity );
	}

}
