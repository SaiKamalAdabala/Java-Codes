package com.cg.BankingApplicationUsingJDBC.service;

import java.sql.SQLException;

import com.cg.BankingApplicationUsingJDBC.beans.AccountDetails;
import com.cg.BankingApplicationUsingJDBC.beans.LoanDetails;
import com.cg.BankingApplicationUsingJDBC.dao.BankingApplicationDAO;
import com.cg.BankingApplicationUsingJDBC.dao.BankingApplicationDAOImpl;

public class BankingApplicationServiceImpl implements BankingApplicationService{
	
	BankingApplicationDAO dao;
	
	public BankingApplicationServiceImpl() throws Exception {
		dao= new BankingApplicationDAOImpl();
	}

	@Override
	public boolean validateAccountId(String id) {
		String regexId = "^[0-9]{7}[A-Za-z]{4}$";
		return id.matches(regexId);
	}

	@Override
	public boolean validateAccountName(String name) {
		String regexName = "^[A-Z]{1}[a-z]{2,30}$";
		return name.matches(regexName);
	}

	@Override
	public int depositAmount(String accId, int amt) throws SQLException {
		// TODO Auto-generated method stub
		return dao.depositAmount(accId, amt);
	}

	@Override
	public int withdrawAmount(String accId, int amt) throws SQLException {
		// TODO Auto-generated method stub
		return dao.withdrawAmount(accId, amt);
	}

	@Override
	public AccountDetails showAccountDetails(String accountNo) throws SQLException {
		return dao.showAccountDetails(accountNo);
		
	}

	@Override
	public void createAccount(AccountDetails account) throws SQLException {
		dao.createAccount(account);
		
	}
	
	public int getLoan(int loanId,int lamt) throws SQLException {
		return dao.getLoan(loanId, lamt);
	}

	@Override
	public LoanDetails showLoanDetails(int loanId) throws SQLException {
		return dao.showLoanDetails(loanId);
		
	}

	@Override
	public int payLoan(int loanId, int lamt) throws SQLException {
		return dao.payLoan(loanId, lamt);
	}

}
