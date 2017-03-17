package com.sisga.domain.provider.filter;

import com.sisga.domain.filter.impl.DomainSpecificEntityFilter;
import com.sisga.domain.provider.Provider;

public class ProviderFilter extends DomainSpecificEntityFilter <Provider> {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 }
