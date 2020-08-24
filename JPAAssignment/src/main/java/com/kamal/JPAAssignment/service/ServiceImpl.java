package com.kamal.JPAAssignment.service;

import java.util.List;


import com.kamal.JPAAssignment.beans.AccountDetails;
import com.kamal.JPAAssignment.beans.LoanDetails;
import com.kamal.JPAAssignment.beans.TransactionDetails;
import com.kamal.JPAAssignment.dao.DaoImpl;
import com.kamal.JPAAssignment.dao.Dao;

public class ServiceImpl implements Service{
	
	Dao dao;
	
	public ServiceImpl() {
		dao = new DaoImpl();
	}

	public boolean accountIdValidation(String id) {
		// TODO Auto-generated method stub
		String regexId = "^[0-9]{7}[A-Za-z]{4}$";
		return id.matches(regexId);
	}

	public boolean accountNameValidation(String name) {
		// TODO Auto-generated method stub
		String regexName = "^[A-Z]{1}[a-z]{2,30}$";
		return name.matches(regexName);

	}

	public void createAccount(AccountDetails acc) {
		// TODO Auto-generated method stub
		dao.createAccount(acc);
	}

	public void createAccountWithLoan(LoanDetails loan) {
		// TODO Auto-generated method stub
		dao.createAccountWithLoan(loan);
		
	}

	public AccountDetails getAccDetails(String accId) {
		// TODO Auto-generated method stub
		return dao.getAccDetails(accId);

	}

	public LoanDetails getLoanDetails(String accId) {
		// TODO Auto-generated method stub
		return dao.getLoanDetails(accId);
	}

	public double depositAmount(String accId, double amt) {
		// TODO Auto-generated method stub
		return dao.depositAmount(accId, amt);
	}

	public double withdrawAmount(String accId, double amt) {
		// TODO Auto-generated method stub
		return dao.withdrawAmount(accId, amt);
	}

	public double payLoan(String accId, double amt) {
		// TODO Auto-generated method stub
		return dao.payLoan(accId, amt);
	}

	public double getLoan(String loanId, double a) {
		// TODO Auto-generated method stub
		return dao.getLoan(loanId, a);
	}

	public List<TransactionDetails> getTransactionDetails(String accountId) {
		// TODO Auto-generated method stub
		return dao.getTransactionDetails(accountId);
	}
	
	

}
