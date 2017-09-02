package com.sisga.domain.order;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.product.Product;
import com.sisga.domain.product.SaleType;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         2 de set de 2017
 */
public class OrderItem extends AbstractDomainEntity {
	private Product product;
	private Integer amount;
	private Double unitValue;
	private SaleType saleType;
	private Double totalValue;

	public Product getProduct() {
		return product;
	}

	public void setProduct( Product product ) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount( int amount ) {
		this.amount = amount;
	}

	public Double getUnitValue() {
		return unitValue;
	}

	public void setUnitValue( Double unitValue ) {
		this.unitValue = unitValue;
	}

	public SaleType getSaleType() {
		return saleType;
	}

	public void setSaleType( SaleType saleType ) {
		this.saleType = saleType;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue( Double totalValue ) {
		this.totalValue = totalValue;
	}

	public void setAmount( Integer amount ) {
		this.amount = amount;
	}

}
