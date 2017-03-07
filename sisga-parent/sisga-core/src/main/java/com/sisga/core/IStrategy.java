package com.sisga.core;

import com.sisga.domain.AbstractDomainEntity;

public interface IStrategy < T extends AbstractDomainEntity > {
	public String process( T entity );
}
