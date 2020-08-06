package com.cg.charecterscount;

public class CharecterBean {
	
	//variables
	private String name;
	private Integer distinctCharecterCount;
	
	//getters and setters methods
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDistinctCharecterCount() {
		return distinctCharecterCount;
	}
	public void setDistinctCharecterCount(Integer distinctCharecterCount) {
		this.distinctCharecterCount = distinctCharecterCount;
	}
	
	
	//contsructors
	
	public CharecterBean() {
		super();
	}
	
	
	public CharecterBean(String name, Integer distinctCharecterCount) {
		super();
		this.name = name;
		this.distinctCharecterCount = distinctCharecterCount;
	}
	
	
	
	//overriding toString method
	
	@Override
	public String toString() {
		return "CharecterBean "
				+ "name=  " + name +     " ,      has" + distinctCharecterCount +" distinctCharecterCount  ";
	}
	
	
	
	

}
