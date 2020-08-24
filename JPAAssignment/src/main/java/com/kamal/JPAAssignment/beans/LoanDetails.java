package com.kamal.JPAAssignment.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class LoanDetails extends AccountDetails{
	
	private String loanId;
	private double loanAmt;
	@Enumerated(EnumType.STRING)
	private LoanType loanType;
	
	
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public double getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(double loanAmt) {
		this.loanAmt = loanAmt;
	}
	public LoanType getLoanType() {
		return loanType;
	}
	public void setLoanTypee(LoanType loanType) {
		this.loanType = loanType;
	}
	public LoanDetails(String acc_Id, String accHolderName, double depositAmount, AddressDetails address, String loanId, double loanAmt,
			LoanType loanType) {
		super(acc_Id, accHolderName, depositAmount, address);
		this.loanId = loanId;
		this.loanAmt = loanAmt;
		this.loanType = loanType;
	}
	public LoanDetails() {
		super();
		
	}
	
	

}
