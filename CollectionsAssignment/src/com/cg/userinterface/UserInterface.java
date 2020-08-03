package com.cg.userinterface;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.cg.bean.EmpAddress;
import com.cg.bean.EmpDepartment;
import com.cg.bean.EmpDetails;
import com.cg.services.EmployeeService;
import com.cg.services.EmployeeServiceImpl;

public class UserInterface {

	
	public static void main(String[] args) {
		
		EmployeeService service= new EmployeeServiceImpl();
		EmpDetails employee = null;
		EmpDepartment department= null;
		Set<EmpAddress> address= null;
		Scanner sc= new Scanner(System.in);
		
		
		while(true) {
			System.out.println("Please Select an option");
			System.out.println("1. To create an Employee");
			System.out.println("2. Sort by EmployeeID");
			System.out.println("3. Sort by FirstName");
			System.out.println("4. Sort by LastName");
			System.out.println("5. Sort by Salary");
			System.out.println("6. Sort by Address");
			System.out.println("7. Sort by Department");
			System.out.println("8. Exit");
			
			
			switch(sc.nextInt()) {
			
			case 1:
				
				
				System.out.println("Enter the employee id:");
				String empId = sc.next();
				if(service.validateEmpId(empId)) {
					employee= new EmpDetails();
					employee.setEmployeeId(empId);
				}else {
					System.out.println("Invalid Formatof Employee ID.Please give proper Employee ID ");
					break;
					
				}
				System.out.println("Please enter your FirstName:");
				String fname= sc.next();
				if(service.validateName(fname)) {
					employee.setFirstName(fname);
				}else {
					System.out.println("Please enter valid FirstName");
					break;
					
				}
				
				System.out.println("Please enter your LastName:");
				String lname= sc.next();
				if(service.validateName(lname)) {
					employee.setLastName(lname);
					
				}else {
					System.out.println("Please enter valid LastName");
					break;
				}
				
				System.out.println("Please enter your Salary in the range of 20000 and 500000  :");
					
					double sal = sc.nextDouble();
					if(service.validateSalary(sal)) {
						employee.setSalary(sal);
				}else {
					System.out.println("Please enter your salary in the given range");
					break;
				}
					System.out.println("Please enter your joining date in the format of 'yyyy-MM-dd':");
					String joinDate=sc.next();
					LocalDate date = LocalDate.parse(joinDate);
					if(service.vaidateJoinDate(date)) {
						employee.setDateOfJoining(date);
					}
					else {
						System.out.println("Please enter the joining date in the given format only!!");
						break;
					}
					
					
					System.out.println("Please enter your Department ID:");
					int deptId= sc.nextInt();
					department.setDeptId(deptId);
					System.out.println("Please enter your Department name:");
					department.setDeptName(sc.next());
					System.out.println("Please enter your location");
					department.setLocation(sc.next());
					
					employee.setDepartment(department);
					
					System.out.println("Please enter your address:");
					int k = sc.nextInt();
					address= new HashSet<EmpAddress>(k);
					for(int i=0;i<k;i++) {
						EmpAddress addr= new EmpAddress();
						System.out.println("Please enter address Id : ");
					addr.setAddressId(sc.nextInt());
					System.out.println("Please enter address line 1");
					addr.setAddressId(sc.nextInt());
					System.out.println("Please enter City");
					addr.setCity(sc.next());
					System.out.println("Please enter State:");
					addr.setState(sc.next());
					address.add(addr);
					}
					
					
				employee.setAddress(address);
				service.createEmployee(employee);
				break;
				
			
					
			case 2:
				
				System.out.println("Sort By EmployeeID :");
				Comparator<EmpDetails> sortById= new Comparator<EmpDetails>() {

					@Override
					public int compare(EmpDetails e1, EmpDetails e2) {
						// TODO Auto-generated method stub
						return e1.getEmployeeId().compareTo(e2.getEmployeeId());
					}
					
				};
				Collections.sort(service.getEmployees(),sortById);
				for(EmpDetails emplo:service.getEmployees())
					System.out.println(emplo);
				break;
				
				
				
				
			case 3:
				
				System.out.println("Sort by FirstName ");
				Comparator<EmpDetails> sortByFName = new Comparator<EmpDetails>() {

					@Override
					public int compare(EmpDetails e1, EmpDetails e2) {
						// TODO Auto-generated method stub
						return e1.getFirstName().compareTo(e2.getFirstName());
						
					}
					
				};
			Collections.sort(service.getEmployees(),sortByFName);
			for(EmpDetails emplo: service.getEmployees())
				System.out.println(emplo);
			
				
				break;
				
				
			case 4:
				
				System.out.println("Sort by LastName ");
				Comparator<EmpDetails> sortByLName = new Comparator<EmpDetails>() {

					@Override
					public int compare(EmpDetails e1, EmpDetails e2) {
						// TODO Auto-generated method stub
						return e1.getLastName().compareTo(e2.getLastName());
						
					}
					
				};
			Collections.sort(service.getEmployees(),sortByLName);
			for(EmpDetails emplo: service.getEmployees())
				System.out.println(emplo);
			
				
				break;
				
				
				
			case 5:

					System.out.println("Sort by Salary ");
					Comparator<EmpDetails> sortBySalary = new Comparator<EmpDetails>() {

						@Override
						public int compare(EmpDetails e1, EmpDetails e2) {
							// TODO Auto-generated method stub
							
							if(e1.getSalary()<e2.getSalary()) 
								return 1;
								else if(e1.getSalary()>e2.getSalary())
									return -1;
								else 
			
							return 0;
						}
						
					};
				Collections.sort(service.getEmployees(),sortBySalary);
				for(EmpDetails emp : service.getEmployees())
					System.out.println(emp);
				break;
				
				
				
				
			case 6:
				
//				for(EmpDetails e : service.getEmployees()) {
//					Collections.sort(  e.getAddress(),new Comparator<EmpAddress>(){
//						public int compare(Address a1,Address a2) {
//							return a1.getAddressId()-a2.getAddressId();
//						}
//
//						@Override
//						public int compare(EmpAddress o1, EmpAddress o2) {
//							// TODO Auto-generated method stub
//							return 0;
//						}
//					} 
//					);
//				}
//				for(EmpDetails emp : service.getEmployees())
//					System.out.println(emp);
//				break;
				
				System.out.println("Sort by Address");
				
				Comparator<EmpAddress> sortByAddress = new Comparator<EmpAddress>(){

					

					@Override
					public int compare(EmpAddress a1, EmpAddress a2) {
						// TODO Auto-generated method stub
						return a1.getAddressId()-a2.getAddressId();
					}
					
				};	
				
			//	Collections.sort(service.getEmployees(),sortByAddress);
				for(EmpDetails emp: service.getEmployees())
					System.out.println(emp);
				break;
				
				
			
				
				
				
			case 7:
				System.out.println("Sort by Department Id ");
				
				Comparator<EmpDepartment> sortByDepartment = new Comparator<EmpDepartment>() {

					

					@Override
					public int compare(EmpDepartment ed1, EmpDepartment ed2) {
						// TODO Auto-generated method stub
						return ed1.getDeptId()-ed2.getDeptId();
					}
				
				};	
				
				//Collections.sort(service.getEmployees(),sortByDepartment);
				for(EmpDetails emp: service.getEmployees())
					System.out.println(emp);
				break;
				
				
				
			case 8:
				
			System.out.println("Thankyou");
			break;
				
			}
			
		}
		
	
	}

	
}
