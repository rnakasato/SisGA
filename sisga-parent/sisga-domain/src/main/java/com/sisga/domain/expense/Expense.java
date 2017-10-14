package com.sisga.domain.expense;

import java.util.Calendar;

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
	private Calendar expenseDate;

	/**
	 * @return the expenseItem
	 */
	public ExpenseItem getExpenseItem() {
		return expenseItem;
	}

	/**
	 * @param expenseItem
	 *            the expenseItem to set
	 */
	public void setExpenseItem( ExpenseItem expenseItem ) {
		this.expenseItem = expenseItem;
	}

	/**
	 * @return the expenseStatus
	 */
	public ExpenseStatus getExpenseStatus() {
		return expenseStatus;
	}

	/**
	 * @param expenseStatus
	 *            the expenseStatus to set
	 */
	public void setExpenseStatus( ExpenseStatus expenseStatus ) {
		this.expenseStatus = expenseStatus;
	}

	/**
	 * @return the expenseType
	 */
	public ExpenseType getExpenseType() {
		return expenseType;
	}

	/**
	 * @param expenseType
	 *            the expenseType to set
	 */
	public void setExpenseType( ExpenseType expenseType ) {
		this.expenseType = expenseType;
	}

	/**
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount( Long amount ) {
		this.amount = amount;
	}

	/**
	 * @return the unitValue
	 */
	public Double getUnitValue() {
		return unitValue;
	}

	/**
	 * @param unitValue
	 *            the unitValue to set
	 */
	public void setUnitValue( Double unitValue ) {
		this.unitValue = unitValue;
	}

	/**
	 * @return the serviceValue
	 */
	public Double getServiceValue() {
		return serviceValue;
	}

	/**
	 * @param serviceValue
	 *            the serviceValue to set
	 */
	public void setServiceValue( Double serviceValue ) {
		this.serviceValue = serviceValue;
	}

	/**
	 * @return the serviceDescription
	 */
	public String getServiceDescription() {
		return serviceDescription;
	}

	/**
	 * @param serviceDescription
	 *            the serviceDescription to set
	 */
	public void setServiceDescription( String serviceDescription ) {
		this.serviceDescription = serviceDescription;
	}

	/**
	 * @return the expenseDate
	 */
	public Calendar getExpenseDate() {
		return expenseDate;
	}

	/**
	 * @param expenseDate
	 *            the expenseDate to set
	 */
	public void setExpenseDate( Calendar expenseDate ) {
		this.expenseDate = expenseDate;
	}

}
