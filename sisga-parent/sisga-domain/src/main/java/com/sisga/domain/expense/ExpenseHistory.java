package com.sisga.domain.expense;

import java.util.Date;

import com.sisga.domain.AbstractDomainEntity;

/**
 * 
 * @author Rafael Hikaru Nakasato
 *         7 de mar de 2017
 */
public class ExpenseHistory extends AbstractDomainEntity {
	private Expense expense;
	private ExpenseOperation expenseOperation;
	private ExpenseItem expenseItem;
	private ExpenseType expenseType;
	private ExpenseStatus expenseStatus;
	// ADICIONAR Provider

	private Long amount;
	private Double unitValue;
	private Double serviceValue;
	private String serviceDescription;
	private Date expenseDate;
	private String phoneDdd;
	private String phoneNumber;
	private String cellphoneDdd;
	private String cellphoneNumber;

	public Expense getExpense() {
		return expense;
	}

	public void setExpense( Expense expense ) {
		this.expense = expense;
	}

	public ExpenseOperation getExpenseOperation() {
		return expenseOperation;
	}

	public void setExpenseOperation( ExpenseOperation expenseOperation ) {
		this.expenseOperation = expenseOperation;
	}

	public ExpenseItem getExpenseItem() {
		return expenseItem;
	}

	public void setExpenseItem( ExpenseItem expenseItem ) {
		this.expenseItem = expenseItem;
	}

	public ExpenseType getExpenseType() {
		return expenseType;
	}

	public void setExpenseType( ExpenseType expenseType ) {
		this.expenseType = expenseType;
	}

	public ExpenseStatus getExpenseStatus() {
		return expenseStatus;
	}

	public void setExpenseStatus( ExpenseStatus expenseStatus ) {
		this.expenseStatus = expenseStatus;
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

	public String getPhoneDdd() {
		return phoneDdd;
	}

	public void setPhoneDdd( String phoneDdd ) {
		this.phoneDdd = phoneDdd;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber( String phoneNumber ) {
		this.phoneNumber = phoneNumber;
	}

	public String getCellphoneNumber() {
		return cellphoneNumber;
	}

	public void setCellphoneNumber( String cellphoneNumber ) {
		this.cellphoneNumber = cellphoneNumber;
	}

	public String getCellphoneDdd() {
		return cellphoneDdd;
	}

	public void setCellphoneDdd( String cellphoneDdd ) {
		this.cellphoneDdd = cellphoneDdd;
	}

}
