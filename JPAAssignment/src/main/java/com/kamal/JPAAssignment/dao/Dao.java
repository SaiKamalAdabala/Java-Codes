package com.kamal.JPAAssignment.dao;

import java.util.List;


import com.kamal.JPAAssignment.beans.AccountDetails;
import com.kamal.JPAAssignment.beans.LoanDetails;
import com.kamal.JPAAssignment.beans.TransactionDetails;

public interface Dao {
	
	public void createAccount(AccountDetails acc);
	public void createAccountWithLoan(LoanDetails loan);	
	public AccountDetails getAccDetails(String accId);
	public LoanDetails getLoanDetails(String accId);
	public double depositAmount(String accId,double amt);
	public double withdrawAmount(String accId,double amt);
	public double payLoan(String accId,double amt);
	public double getLoan(String loanId,double am);
	public List<TransactionDetails> getTransactionDetails(String accountId);
}
