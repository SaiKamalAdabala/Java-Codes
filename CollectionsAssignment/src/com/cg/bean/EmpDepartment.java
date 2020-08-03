package com.cg.bean;

public class EmpDepartment {
	

	//variables
	private int deptId;
	private String deptName;
	private String location;
	
	//getters and setters 
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public EmpDepartment() {
		
	}
	
	public EmpDepartment(int deptId, String deptName, String location) {
		super();
		this.deptId=deptId;
		this.deptName=deptName;
		this.location=location;
	}

	
	@Override
	public String toString() {
		return "DepartmentDetailsOfEmployee: [deptId=" + deptId + ", deptName=" + deptName + ", location=" + location + "]";
	}
}
