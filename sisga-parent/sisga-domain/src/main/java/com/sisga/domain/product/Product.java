package com.sisga.domain.product;

import com.sisga.domain.AbstractDomainEntity;
import com.sisga.domain.DomainSpecificEntity;

/**
 * 
 * @author Rafael Hikaru Nakasato 7 de mar de 2017
 */
public class Product extends DomainSpecificEntity {
	private Double baseValue;
	private String photo;
	private SaleType saleType;
	private ProductionType productionType;
	private StockType stockType;
	private Long amount;

	public Double getBaseValue() {
		return baseValue;
	}

	public void setBaseValue( Double baseValue ) {
		this.baseValue = baseValue;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto( String photo ) {
		this.photo = photo;
	}

	public SaleType getSaleType() {
		return saleType;
	}

	public void setSaleType( SaleType saleType ) {
		this.saleType = saleType;
	}

	public ProductionType getProductionType() {
		return productionType;
	}

	public void setProductionType( ProductionType productionType ) {
		this.productionType = productionType;
	}

	public StockType getStockType() {
		return stockType;
	}

	public void setStockType( StockType stockType ) {
		this.stockType = stockType;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount( Long amount ) {
		this.amount = amount;
	}

}
