package com.sisga.core.business;

import com.sisga.core.IStrategy;
import com.sisga.domain.AbstractDomainEntity;

public abstract class AbstractStrategy < T extends AbstractDomainEntity > implements IStrategy < T > {
	protected String msg;
}
