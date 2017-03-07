package com.sisga.core;

import com.sisga.core.application.Result;
import com.sisga.domain.AbstractDomainEntity;

public interface ICommand < T extends AbstractDomainEntity > {
	public Result < T > execute();
}
