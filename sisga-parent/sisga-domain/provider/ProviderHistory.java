package com.sisga.domain.provider;

import java.util.List;

import com.sisga.domain.DomainSpecificEntity;
import com.sisga.domain.address.City;
import com.sisga.domain.communication.Telephone;

/**
 * 
 * @author Sergio Massao Umiji
 *         10 de mar de 2017
 */

public class ProviderHistory extends DomainSpecificEntity{

	private Provider provider;
	private String firstName;
	private String cnpj;
	private boolean active;
	private ProviderOperation providerOperation;
	private List<Telephone> telephones;
	private String email;
	private City city;
	private String number;
	private String neighborhood;
	
	
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public ProviderOperation getProviderOperation() {
		return providerOperation;
	}
	public void setProviderOperation(ProviderOperation providerOperation) {
		this.providerOperation = providerOperation;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public List<Telephone> getTelephones() {
		return telephones;
	}
	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	} 
}
