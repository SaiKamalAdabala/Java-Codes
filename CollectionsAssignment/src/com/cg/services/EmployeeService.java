package com.cg.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.cg.bean.EmpDetails;

public interface EmployeeService {

	
	public boolean validateEmpId(String empId);
	public boolean validateSalary(double sal);
	public boolean validateName(String name);
	public boolean vaidateJoinDate(LocalDate date);
	
	public void createEmployee(EmpDetails emp);
	public List<EmpDetails> getEmployees();
}
