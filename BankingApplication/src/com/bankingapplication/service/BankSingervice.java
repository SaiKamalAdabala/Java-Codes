package com.bankingapplication.service;

import com.bankingapplication.benas.AccountDetails;
import com.bankingapplication.benas.LoanDetails;

public interface BankSingervice {
	
	public boolean validateAccountId(String id);
	public boolean validateAccountName(String name);
	
	public int depositAmount(String accId,int amt);
	public int withdrawAmount(String accId,int amt);
	public AccountDetails showAccountDetails(String accountNo);
	public void createAccount(AccountDetails account);
	
	public int getLoan(long loanId,int lamt);
	public int payLoan(long loanId,int lamt);
	public LoanDetails showLoanDetails(long loanId);
}
