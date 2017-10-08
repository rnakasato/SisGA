package com.sisga.domain.customer.filter;

import com.sisga.domain.customer.Customer;
import com.sisga.domain.filter.impl.DomainSpecificEntityFilter;

/**
 * 
 * @author Sergio Massao Umiji
 *         17 de mar de 2017
 */

public class CustomerFilter extends DomainSpecificEntityFilter < Customer > {
	private String name;
	private String status;
	private String code;
	private String cnpj;
	private String corporateName;

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus( String status ) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode( String code ) {
		this.code = code;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj( String cnpj ) {
		this.cnpj = cnpj;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName( String corporateName ) {
		this.corporateName = corporateName;
	}

}
