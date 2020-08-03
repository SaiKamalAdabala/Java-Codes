package com.cg.dao;

import java.util.List;
import java.util.Set;

import com.cg.bean.EmpDetails;

public interface EmployeeDao {

	void createEmployee(EmpDetails emp);

	List<EmpDetails> getEmployees();

}
