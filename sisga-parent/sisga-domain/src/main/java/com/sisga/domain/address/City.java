package com.sisga.domain.address;

import com.sisga.domain.DomainSpecificEntity;

public class City extends DomainSpecificEntity{
	private String uf;
	private String name;
	private State state;
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
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
