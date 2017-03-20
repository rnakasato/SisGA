package com.sisga.domain.product.filter;

import com.sisga.domain.filter.impl.DomainSpecificEntityFilter;
import com.sisga.domain.product.ProductHistory;
import com.sisga.domain.product.ProductionType;
import com.sisga.domain.product.SaleType;
import com.sisga.domain.product.StockType;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         10 de mar de 2017
 */
public class ProductHistoryFilter extends DomainSpecificEntityFilter < ProductHistory > {
	private SaleType saleType;
	private ProductionType productionType;
	private StockType stockType;

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

}
