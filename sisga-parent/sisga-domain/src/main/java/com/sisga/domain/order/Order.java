package com.sisga.domain.order;

import java.util.Calendar;
import java.util.List;

import com.sisga.domain.DomainSpecificEntity;
import com.sisga.domain.customer.Customer;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         2 de set de 2017
 */
public class Order extends DomainSpecificEntity {
	private List < OrderItem > orderItems;
	private Customer customer;
	private Calendar deliverDate;
	private OrderStatus orderStatus;

	public List < OrderItem > getOrderItems() {
		return orderItems;
	}

	public void setOrderItems( List < OrderItem > orderItems ) {
		this.orderItems = orderItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer( Customer customer ) {
		this.customer = customer;
	}

	public Calendar getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate( Calendar deliverDate ) {
		this.deliverDate = deliverDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus( OrderStatus orderStatus ) {
		this.orderStatus = orderStatus;
	}

}
