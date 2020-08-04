package com.cg.services;

import java.time.LocalDate;
import java.util.List;


import com.cg.bean.EmpDetails;
import com.cg.dao.EmployeeDao;
import com.cg.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao dao;
	
	 public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
		 
		 dao= new EmployeeDaoImpl();
	}

	@Override
	public boolean validateEmpId(String empId) {
		// TODO Auto-generated method stub
		String regex = "^[0-9]{5}_[A-Z]{2}$";
		return empId.matches(regex);
	
	}

	@Override
	public boolean validateSalary(double sal) {
		// TODO Auto-generated method stub
		return (sal>=20000 && sal<= 500000);
	}

	@Override
	public boolean validateName(String name) {
		// TODO Auto-generated method stub
		return name.matches("^[A-Za-z]{5,}$");
	}

	@Override
	public boolean vaidateJoinDate(LocalDate date) {
		// TODO Auto-generated method stub
		int flag = date.compareTo(LocalDate.now());
		return (flag>=0);
	}

	@Override
	public void createEmployee(EmpDetails emp) {
		// TODO Auto-generated method stub
		dao.createEmployee(emp);
	}

	@Override
	public List<EmpDetails> getEmployees() {
		// TODO Auto-generated method stub
		return dao.getEmployees();
	}

}
