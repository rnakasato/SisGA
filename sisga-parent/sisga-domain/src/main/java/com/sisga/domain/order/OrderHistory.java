package com.sisga.domain.order;

import java.util.List;

public class OrderHistory extends Order {

	// Dados de pedido
	private Order order;

	// Dados de item pedido
	// Se for um pedido alterado devera estar preenchido, caso tenha sido
	// excluido o pedido ele será null
	private List < OrderItemHistory > orderItemHistoryList;

	public Order getOrder() {
		return order;
	}

	public void setOrder( Order order ) {
		this.order = order;
	}

	public List < OrderItemHistory > getOrderItemHistoryList() {
		return orderItemHistoryList;
	}

	public void setOrderItemHistoryList( List < OrderItemHistory > orderItemHistoryList ) {
		this.orderItemHistoryList = orderItemHistoryList;
	}

}
