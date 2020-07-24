package com.bankingapplication.benas;

public class AccountDetails {
	private String accountId;
	private String accountName;
	private Address addres;
	private int depositAmount;
	
	public String getDetails() {
		return getAccountName()+" "+getAccountId()+" "+addres.getCity()+" "+addres.getState()+" "+getDepositAmount();
	}
	
	public void shpowDetails() {
		System.out.println("Account Name :"+getAccountName());
		System.out.println("Account Id : "+getAccountId());
		System.out.println("Address : "+getAddres().getCity()+" "+getAddres().getState());
		System.out.println("Deposit Amount is :"+getDepositAmount());
	}
	
	
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", city=" + addres.getCity()+" state= "+addres.getState()
				+ ", depositAmount=" + depositAmount + "]";
	}

	public String getAccountId() {
		return accountId;
	}
	public AccountDetails() {
		super();
	}
	public AccountDetails(String accountId, String accountName, Address addres, int depositAmount) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.addres = addres;
		this.depositAmount = depositAmount;
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
	public Address getAddres() {
		return addres;
	}
	public void setAddres(Address addres) {
		this.addres = addres;
	}
	public int getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}
	
	
}
