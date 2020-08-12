package com.cg.BankingApplicationUsingJDBC.beans;

public class AddressDetails {
	
	private String city;
	private String state;
	
	
	//getters and setters
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	//constructors
	
	public AddressDetails() {
		super();
	}
	
	public AddressDetails(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}
	
	
	//overriding toString Method
	@Override
	public String toString() {
		return "AddressDetails [city=" + city + ", state=" + state + "]";
	}
	
	
	
	

}
