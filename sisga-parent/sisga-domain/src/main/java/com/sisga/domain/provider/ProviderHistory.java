package com.sisga.domain.provider;

import com.sisga.domain.person.PersonHistory;

/**
 * 
 * @author Sergio Massao Umiji 10 de mar de 2017
 */

public class ProviderHistory extends PersonHistory {

	private Provider provider;
	private String corporateName;
	private String cnpj;
	private ProviderOperation providerOperation;

	/**
	 * @return the provider
	 */
	public Provider getProvider() {
		return provider;
	}

	/**
	 * @param provider
	 *            the provider to set
	 */
	public void setProvider( Provider provider ) {
		this.provider = provider;
	}

	/**
	 * @return the corporateName
	 */
	public String getCorporateName() {
		return corporateName;
	}

	/**
	 * @param corporateName
	 *            the corporateName to set
	 */
	public void setCorporateName( String corporateName ) {
		this.corporateName = corporateName;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj
	 *            the cnpj to set
	 */
	public void setCnpj( String cnpj ) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the providerOperation
	 */
	public ProviderOperation getProviderOperation() {
		return providerOperation;
	}

	/**
	 * @param providerOperation
	 *            the providerOperation to set
	 */
	public void setProviderOperation( ProviderOperation providerOperation ) {
		this.providerOperation = providerOperation;
	}

}
