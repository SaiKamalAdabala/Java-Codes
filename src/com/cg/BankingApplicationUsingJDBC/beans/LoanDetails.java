package com.cg.BankingApplicationUsingJDBC.beans;

public class LoanDetails extends AccountDetails{
	
	private int loanId;
	private int loanAmount;
	private LoanTypeDetails loanType;
	

	
	public void showLoanDetails() {
		System.out.println("Loan Id = "+getLoanId());
		System.out.println("Loan amount = "+getLoanAmount());
		System.out.println("Loan Type = "+getLoanType());
	}
	

//getters and setters

	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public LoanTypeDetails getLoanType() {
		return loanType;
	}
	public void setLoanType(LoanTypeDetails loanType) {
		this.loanType = loanType;
	}
	
	

}
