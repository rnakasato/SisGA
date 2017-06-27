package com.sisga.core.factory.strategy;

import java.util.List;
import java.util.Map;

import com.sisga.core.IStrategy;
import com.sisga.domain.AbstractDomainEntity;

/**
 * 
 * @author rafae
 *
 */
public interface IEntityStrategyFactory < T extends AbstractDomainEntity > {
	public Map<String, Map<String, List<IStrategy>>> buildEntityRules();
}
