package com.sisga.domain.address;

import com.sisga.domain.DomainSpecificEntity;

public class State extends DomainSpecificEntity{
	private String name;
	private String uf;

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	}
