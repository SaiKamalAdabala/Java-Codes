package com.cg.dao;




import java.util.ArrayList;
import java.util.List;


import com.cg.bean.EmpDetails;

public class EmployeeDaoImpl  implements EmployeeDao{

	
	List<EmpDetails> empl= new ArrayList<EmpDetails>();
	@Override
	public void createEmployee(EmpDetails emp) {
		// TODO Auto-generated method stub
		
		empl.add(emp);
		System.out.println("Your Employee is Created");
		
		
	}

	@Override
	public List<EmpDetails> getEmployees(){
		// TODO Auto-generated method stub
		return empl;
	}

}
