package com.cg.BankingApplicationUsingJDBC.beans;

public class AccountDetails {
	private String accountId;
	private String accountName;
	private String address;
	private double depositAmount;
	
	
	public void showDetails() {
		System.out.println("Account Name :"+getAccountName());
		System.out.println("Account Id : "+getAccountId());
		System.out.println("Address : "+getAddress());
		System.out.println("Deposit Amount is :"+getDepositAmount());
	}
	
	
	//getters and setters

	public String getAccountId() {
		return accountId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddres(String address) {
		this.address = address;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	
	
	//constructors
	public AccountDetails() {
		super();
	}
	public AccountDetails(String accountId, String accountName, String address, int depositAmount) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.address = address;
		this.depositAmount = depositAmount;
	}
	
	//overriding tostring Method 
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", address =" + address+
				 ", depositAmount=" + depositAmount + "]";
	}
}
