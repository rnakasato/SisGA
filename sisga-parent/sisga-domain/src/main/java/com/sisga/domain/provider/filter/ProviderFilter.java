package com.sisga.domain.provider.filter;

import com.sisga.domain.filter.impl.DomainSpecificEntityFilter;
import com.sisga.domain.provider.Provider;

/**
 * 
 * @author Sergio Massao Umiji
 *         17 de mar de 2017
 */

public class ProviderFilter extends DomainSpecificEntityFilter <Provider> {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 }
