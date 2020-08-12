package com.cg.BankingApplicationUsingJDBC.service;

import java.sql.SQLException;

import com.cg.BankingApplicationUsingJDBC.beans.AccountDetails;
import com.cg.BankingApplicationUsingJDBC.beans.LoanDetails;

public interface BankingApplicationService {
	
	public boolean validateAccountId(String id);
	public boolean validateAccountName(String name);
	
	public void createAccount(AccountDetails account) throws SQLException;
	public int depositAmount(String accId,int amt) throws SQLException;
	public int withdrawAmount(String accId,int amt) throws SQLException;
	public AccountDetails showAccountDetails(String accountNo) throws SQLException;
	public int getLoan(int loanId,int lamt) throws SQLException;
	public int payLoan(int loanId,int lamt) throws SQLException;
	public LoanDetails showLoanDetails(int loanId) throws SQLException;
}
