package com.sisga.domain.customer.filter;

import com.sisga.domain.customer.Customer;
import com.sisga.domain.filter.impl.DomainSpecificEntityFilter;
/**
 * 
 * @author Sergio Massao Umiji
 *         17 de mar de 2017
 */

public class CustomerFilter extends DomainSpecificEntityFilter < Customer >{
	private String name;
	private String status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
