package com.sisga.domain.expense;

import java.util.Calendar;

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
	private Calendar expenseDate;
	private String phoneDdd;
	private String phoneNumber;
	private String cellphoneDdd;
	private String cellphoneNumber;

	/**
	 * @return the expense
	 */
	public Expense getExpense() {
		return expense;
	}

	/**
	 * @param expense
	 *            the expense to set
	 */
	public void setExpense( Expense expense ) {
		this.expense = expense;
	}

	/**
	 * @return the expenseOperation
	 */
	public ExpenseOperation getExpenseOperation() {
		return expenseOperation;
	}

	/**
	 * @param expenseOperation
	 *            the expenseOperation to set
	 */
	public void setExpenseOperation( ExpenseOperation expenseOperation ) {
		this.expenseOperation = expenseOperation;
	}

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

	/**
	 * @return the phoneDdd
	 */
	public String getPhoneDdd() {
		return phoneDdd;
	}

	/**
	 * @param phoneDdd
	 *            the phoneDdd to set
	 */
	public void setPhoneDdd( String phoneDdd ) {
		this.phoneDdd = phoneDdd;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber( String phoneNumber ) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the cellphoneDdd
	 */
	public String getCellphoneDdd() {
		return cellphoneDdd;
	}

	/**
	 * @param cellphoneDdd
	 *            the cellphoneDdd to set
	 */
	public void setCellphoneDdd( String cellphoneDdd ) {
		this.cellphoneDdd = cellphoneDdd;
	}

	/**
	 * @return the cellphoneNumber
	 */
	public String getCellphoneNumber() {
		return cellphoneNumber;
	}

	/**
	 * @param cellphoneNumber
	 *            the cellphoneNumber to set
	 */
	public void setCellphoneNumber( String cellphoneNumber ) {
		this.cellphoneNumber = cellphoneNumber;
	}

}
