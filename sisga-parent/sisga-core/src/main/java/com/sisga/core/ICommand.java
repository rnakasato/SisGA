package com.sisga.core;

import com.sisga.core.application.Result;
import com.sisga.domain.AbstractEntity;

public interface ICommand<T extends AbstractEntity> {
	public Result<T> execute();
}
