package com.kamal.JPAAssignment.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;



@Entity
public class TransactionDetails {
	
	@Id
	@Column(name = "tranId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	@ManyToOne
	private AccountDetails accountId;
	private double transactionAmt;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	public int getTransactionId() {
		return transactionId;
	}

	public AccountDetails getAccountId() {
		return accountId;
	}
	public void setAccountId(AccountDetails accountId) {
		this.accountId = accountId;
	}
	public double getTransactionAmt() {
		return transactionAmt;
	}
	public void setTransactionAmt(double transactionAmt) {
		this.transactionAmt = transactionAmt;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public TransactionDetails( AccountDetails accountId, double transactionAmt, TransactionType transactionType) {
		super();
		
		this.accountId = accountId;
		this.transactionAmt = transactionAmt;
		this.transactionType = transactionType;
	}
	public TransactionDetails() {
		super();
	}
	
	
	
	
	

}
