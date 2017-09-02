package com.sisga.domain.order;

public class OrderItemHistory extends OrderItem {
	private OrderItem orderItem;
	private OrderHistory orderHistory;

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem( OrderItem orderItem ) {
		this.orderItem = orderItem;
	}

	public OrderHistory getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory( OrderHistory orderHistory ) {
		this.orderHistory = orderHistory;
	}

}
