package com.cg.bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class EmpDetails {
	
	//variables declaration
	private String firstName;
	private String lastName;
	private double salary;
	private String employeeId;
	private LocalDate dateOfJoining;
	private EmpDepartment department;
	private Set<EmpAddress> address;
	
	
	//constructors
	
	
	public EmpDetails() {
		
	}
	
	public EmpDetails(String employeeId, String firstName, String lastName, double salary, LocalDate dateOfJoining,List<EmpAddress> address,EmpDepartment department) {
	
		super();
		this.employeeId=employeeId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.salary=salary;
		this.dateOfJoining= dateOfJoining;
		this.address= (Set<EmpAddress>) address;
		this.department=department;
		
	}
	
	
	
	//setters and getters
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public EmpDepartment getDepartment() {
		return department;
	}

	public void setDepartment(EmpDepartment department) {
		this.department = department;
	}

	public Set<EmpAddress> getAddress() {
		return address;
	}

	public void setAddress(Set<EmpAddress> address2) {
		this.address = address2;
	}
	
	
	@Override
	public String toString() {
		return "EmployeeDetails: [empId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", dateOfJoin=" + dateOfJoining + ", address=" + address + ", department=" + department + "]";
		
	}
	
	
	
	
	}
 



