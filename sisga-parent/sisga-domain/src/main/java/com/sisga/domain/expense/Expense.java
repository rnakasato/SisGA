package com.sisga.domain.expense;

import java.util.Date;

import com.sisga.domain.AbstractDomainEntity;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         7 de mar de 2017
 */
public class Expense extends AbstractDomainEntity {

	// ADICIONAR FORNECEDOR
	private ExpenseItem expenseItem;
	private ExpenseStatus expenseStatus;
	private ExpenseType expenseType;

	private Long amount;
	private Double unitValue;
	private Double serviceValue;
	private String serviceDescription;
	private Date expenseDate;
	private boolean active;

	public ExpenseItem getExpenseItem() {
		return expenseItem;
	}

	public void setExpenseItem( ExpenseItem expenseItem ) {
		this.expenseItem = expenseItem;
	}

	public ExpenseStatus getExpenseStatus() {
		return expenseStatus;
	}

	public void setExpenseStatus( ExpenseStatus expenseStatus ) {
		this.expenseStatus = expenseStatus;
	}

	public ExpenseType getExpenseType() {
		return expenseType;
	}

	public void setExpenseType( ExpenseType expenseType ) {
		this.expenseType = expenseType;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount( Long amount ) {
		this.amount = amount;
	}

	public Double getUnitValue() {
		return unitValue;
	}

	public void setUnitValue( Double unitValue ) {
		this.unitValue = unitValue;
	}

	public Double getServiceValue() {
		return serviceValue;
	}

	public void setServiceValue( Double serviceValue ) {
		this.serviceValue = serviceValue;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription( String serviceDescription ) {
		this.serviceDescription = serviceDescription;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate( Date expenseDate ) {
		this.expenseDate = expenseDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive( boolean active ) {
		this.active = active;
	}

}
