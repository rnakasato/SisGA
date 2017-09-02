package com.sisga.domain.order.filter;

import java.util.Calendar;
import java.util.List;

import com.sisga.domain.customer.Customer;
import com.sisga.domain.filter.impl.Filter;
import com.sisga.domain.order.Order;
import com.sisga.domain.order.OrderStatus;
import com.sisga.domain.product.Product;

public class OrderFilter extends Filter < Order > {

	// Na tela de consulta de pedidos do dia fazer o filtro automatico no
	// periodo de um dia
	private Calendar startDate;
	private Calendar endDate;
	private List < Customer > customerList;
	private String orderCode;
	private List < Product > productList;
	private OrderStatus orderStatus;

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate( Calendar startDate ) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate( Calendar endDate ) {
		this.endDate = endDate;
	}

	public List < Customer > getCustomerList() {
		return customerList;
	}

	public void setCustomerList( List < Customer > customerList ) {
		this.customerList = customerList;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode( String orderCode ) {
		this.orderCode = orderCode;
	}

	public List < Product > getProductList() {
		return productList;
	}

	public void setProductList( List < Product > productList ) {
		this.productList = productList;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus( OrderStatus orderStatus ) {
		this.orderStatus = orderStatus;
	}

}
