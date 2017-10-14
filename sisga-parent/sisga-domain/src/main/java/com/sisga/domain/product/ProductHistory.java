package com.sisga.domain.product;

import com.sisga.domain.DomainSpecificEntity;

public class ProductHistory extends DomainSpecificEntity {
	private Product product;
	private ProductionType productionType;
	private SaleType saleType;
	private StockType stockType;
	private ProductOperation productOperation;
	private Long amount;
	private String photo;
	private Double baseValue;

	public Product getProduct() {
		return product;
	}

	public void setProduct( Product product ) {
		this.product = product;
	}

	public ProductionType getProductionType() {
		return productionType;
	}

	public void setProductionType( ProductionType productionType ) {
		this.productionType = productionType;
	}

	public SaleType getSaleType() {
		return saleType;
	}

	public void setSaleType( SaleType saleType ) {
		this.saleType = saleType;
	}

	public StockType getStockType() {
		return stockType;
	}

	public void setStockType( StockType stockType ) {
		this.stockType = stockType;
	}

	public ProductOperation getProductOperation() {
		return productOperation;
	}

	public void setProductOperation( ProductOperation productOperation ) {
		this.productOperation = productOperation;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount( Long amount ) {
		this.amount = amount;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto( String photo ) {
		this.photo = photo;
	}

	public Double getBaseValue() {
		return baseValue;
	}

	public void setBaseValue( Double baseValue ) {
		this.baseValue = baseValue;
	}

	public String getOperationCode() {
		String code = null;
		if( this.productOperation != null ) {
			code = this.productOperation.getCode();
		}
		return code;
	}

	public void setOperationCode( String code ) {
		if( this.productOperation == null ) {
			productOperation = new ProductOperation();
		}
		productOperation.setCode( code );
	}

}
