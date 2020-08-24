package com.kamal.JPAAssignment.service;

import java.util.List;


import com.kamal.JPAAssignment.beans.AccountDetails;
import com.kamal.JPAAssignment.beans.LoanDetails;
import com.kamal.JPAAssignment.beans.TransactionDetails;

public interface Service {
	
	public boolean accountIdValidation(String id);
	public boolean accountNameValidation(String name);
	
	public void createAccount(AccountDetails acc);
	public void createAccountWithLoan(LoanDetails loan);
	
	public AccountDetails getAccDetails(String accId);
	public LoanDetails getLoanDetails(String accId);
	
	public double depositAmount(String accId,double amt);
	public double withdrawAmount(String accId,double amt);
	
	public double payLoan(String accId,double amt);
	public double getLoan(String loan,double a);
	
	public List<TransactionDetails> getTransactionDetails(String accountId);
}
