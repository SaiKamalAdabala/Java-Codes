package com.bankingapplication.benas;

public class LoanDetails extends AccountDetails{
	
	private long loanId;
	private int loanAmount;
	private String loanType;
	
	
	//getLoan()
	
	
	public void showLoanDetails() {
		System.out.println("Loan Id = "+getLoanId());
		System.out.println("Loan amount = "+getLoanAmount());
		System.out.println("Loan Type = "+getLoanType());
	}
	
	
//	@Override
//	public String toString() {
//		return "Loan [loanId=" + loanId + ", loanAmount=" + loanAmount + ", loanType=" + loanType + "]";
//	}


	public long getLoanId() {
		return loanId;
	}
	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
	

}
