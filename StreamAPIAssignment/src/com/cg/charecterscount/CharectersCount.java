package com.cg.charecterscount;

public class CharectersCount {
	
	//variables
	private String name;
	private int distinctCharecterCount;
	
	//getters and setters methods
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDistinctCharecterCount() {
		return distinctCharecterCount;
	}
	public void setDistinctCharecterCount(int distinctCharecterCount) {
		this.distinctCharecterCount = distinctCharecterCount;
	}
	
	
	//contsructors
	
	public CharectersCount() {
		super();
	}
	
	
	public CharectersCount(String name, int count) {
		super();
		this.name = name;
		this.distinctCharecterCount = count;
	}
	
	
	
	//overriding toString method
	
	@Override
	public String toString() {
		return "" + name +  " ---> " + distinctCharecterCount + " distinct characters.";
	}
	
	
	
	

}
