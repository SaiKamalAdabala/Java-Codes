package com.cg.BankingApplicationUsingJDBC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.BankingApplicationUsingJDBC.beans.AccountDetails;
import com.cg.BankingApplicationUsingJDBC.beans.LoanDetails;
import com.cg.BankingApplicationUsingJDBC.beans.LoanTypeDetails;
import com.cg.BankingApplicationUsingJDBC.beans.TransactionDetails;

public class BankingApplicationDAOImpl implements BankingApplicationDAO {
	
	
	int amount = 0;	
	String url="jdbc:mysql://localhost:3306/BankingApplication";
	String uname="root",password="Kamal@0203";	
	Connection connection = DriverManager.getConnection(url,uname,password);

	
	public BankingApplicationDAOImpl() throws Exception {
		
	}
	    
	//create account
	
	@Override
	public void createAccount(AccountDetails account) throws SQLException {
		TransactionDetails t = (TransactionDetails) account;
		String insertQuery = "insert into customer "+"(accountId,accountName,address,depositAmount,loanID,loanAmount,loanType)"+"values(?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(insertQuery);	
		ps.setString(1, t.getAccountId());
		ps.setString(2, t.getAccountName());
		ps.setString(3, t.getAddress());
		ps.setDouble(4, t.getDepositAmount());
		ps.setInt(5, t.getLoanId());
		ps.setInt(6, t.getLoanAmount());
		ps.setString(7, String.valueOf(t.getLoanType()));
		int i = ps.executeUpdate();
		System.out.println(i+" rows affected ");
	}
	
	
	//depositamount
	
	@Override
	public int depositAmount(String accId, int amt) throws SQLException {

		String getDepositAmountQuery = "select depositAmount from customer where accountId = ?";
		PreparedStatement ps = connection.prepareStatement(getDepositAmountQuery);
		ps.setString(1, accId);
		ResultSet resultset = ps.executeQuery();
		resultset.next();
		int amount1 = resultset.getInt(1)+amt;
		String depositAmountUpdateQuery = "update customer set depositAmount = ? where accountId = ?";
		PreparedStatement ps1 = connection.prepareStatement(depositAmountUpdateQuery);
		ps1.setInt(1, amount1);
		ps1.setString(2, accId);
		ps1.executeUpdate();
		return amount1;
	}

	
	//withdraw amount
	
	@Override
	public int withdrawAmount(String accId, int amt) throws SQLException {
		// TODO Auto-generated method stub
	
		String getWithdrawAmountQuery = "select depositAmount from customer where accountId = ?";
		PreparedStatement ps = connection.prepareStatement(getWithdrawAmountQuery);		
		ps.setString(1, accId);
		ResultSet resultset = ps.executeQuery();
		resultset.next();
		int amount1 = resultset.getInt(1)-amt;
		String depositAmountUpdateQuery = "update customer set depositAmount = ? where accountId = ?";
		PreparedStatement ps1 = connection.prepareStatement(depositAmountUpdateQuery);
		ps1.setInt(1, amount1);
		ps1.setString(2, accId);
		ps1.executeUpdate();
		
		return amount1;
	}
	
	//Showaccountdetails

	@Override
	public AccountDetails showAccountDetails(String accountNo) throws SQLException {

		String getAccDetailsQuery = "select accountId,accountName,address,depositAmount from customer where accountId = ?";
		PreparedStatement ps = connection.prepareStatement(getAccDetailsQuery);
		ps.setString(1, accountNo);
		ResultSet resultset = ps.executeQuery();
		resultset.next();
		AccountDetails accountDetails =new AccountDetails();
		accountDetails.setAccountId(resultset.getString(1));
		accountDetails.setAccountName(resultset.getString(2));
		accountDetails.setAddres(resultset.getString(3));
		accountDetails.setDepositAmount(resultset.getDouble(4));
		
		return accountDetails;
	}

	
	//getloan
	
	@Override
	public int getLoan(int loanId, int lamt) throws SQLException {
		// TODO Auto-generated method stub
		int loanBal = 0;

		String depositAmountUpdateQuery = "select loanAmount from customer where loanID = ?";
		PreparedStatement ps = connection.prepareStatement(depositAmountUpdateQuery);
		ps.setInt(1, loanId);
		ResultSet resultset = ps.executeQuery();
		resultset.next();
		loanBal = resultset.getInt(1);
		loanBal += lamt;	
		String updateLoanQuery = "update customer set loanAmount = ? where loanID = ?";
		PreparedStatement ps1 = connection.prepareStatement(updateLoanQuery);
		ps1.setInt(1, loanBal);
		ps1.setInt(2, loanId);
		ps1.executeUpdate();
		
		return loanBal;
	}
	
	
	//payloan
	@Override
	public int payLoan(int loanId, int lamt) throws SQLException {
		int loanBal = 0;

		
		String getLoanQuery = "select loanAmount from customer where loanID = ?";
		PreparedStatement ps = connection.prepareStatement(getLoanQuery);
		ps.setInt(1, loanId);
		ResultSet resultset = ps.executeQuery();
		resultset.next();
		loanBal = resultset.getInt(1);
		loanBal -= lamt;	
		String updateLoanQuery = "update customer set loanAmount = ? where loanID = ?";
		PreparedStatement pst1 = connection.prepareStatement(updateLoanQuery);
		pst1.setInt(1, loanBal);
		pst1.setInt(2, loanId);
		pst1.executeUpdate();
		
		return loanBal;
		
	}
	
	//ShowLoanDetails
	@Override
	public LoanDetails showLoanDetails(int loanId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("select loanID,loanAmount,loanType from customer where loanID = ?");
		ps.setInt(1, loanId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		LoanDetails loanDetails = new LoanDetails();
		loanDetails.setLoanId(rs.getInt(1));
		loanDetails.setLoanAmount(rs.getInt(2));
		loanDetails.setLoanType(LoanTypeDetails.valueOf(rs.getString(3)));
		
		return loanDetails;
				
	}

	
	
	

}
