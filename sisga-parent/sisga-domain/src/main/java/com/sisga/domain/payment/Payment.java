package com.sisga.domain.payment;

import java.util.Calendar;
import java.util.List;

import com.sisga.domain.DomainSpecificEntity;
import com.sisga.domain.order.Order;

public class Payment extends DomainSpecificEntity {
	private Calendar paymentDate;
	private PaymentStatus paymentStatus;
	private List < Order > orderList;
	private Double paymentValue;
	private PaymentType paymentType;

	public Calendar getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate( Calendar paymentDate ) {
		this.paymentDate = paymentDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus( PaymentStatus paymentStatus ) {
		this.paymentStatus = paymentStatus;
	}

	public List < Order > getOrderList() {
		return orderList;
	}

	public void setOrderList( List < Order > orderList ) {
		this.orderList = orderList;
	}

	public Double getPaymentValue() {
		return paymentValue;
	}

	public void setPaymentValue( Double paymentValue ) {
		this.paymentValue = paymentValue;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType( PaymentType paymentType ) {
		this.paymentType = paymentType;
	}

}
