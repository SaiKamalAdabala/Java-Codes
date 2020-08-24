package com.kamal.JPAAssignment.userinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.kamal.JPAAssignment.beans.AccountDetails;
import com.kamal.JPAAssignment.beans.AddressDetails;
import com.kamal.JPAAssignment.beans.LoanDetails;
import com.kamal.JPAAssignment.beans.LoanType;
import com.kamal.JPAAssignment.beans.TransactionDetails;
import com.kamal.JPAAssignment.service.Service;
import com.kamal.JPAAssignment.service.ServiceImpl;

public class UserInterface 
{
	
	static Service service;
	
    public static void main( String[] args ) throws IOException
    {
    	
    	AccountDetails account;
    	LoanDetails loan;
    	
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("<---------------------------------->");
			System.out.println("Choose any one");
			System.out.println("Enter 1 for Create account");
			System.out.println("Enter 2 for Deposit");
			System.out.println("Enter 3 for Withdraw");
			System.out.println("Enter 4 for ShowAccountDetails");
			System.out.println("Enter 5 for GetLoan");
			System.out.println("Enter 6 for PayLoan");
			System.out.println("Enter 7 for ShowLoanDetails");
			System.out.println("Enter 8 for ShowTransactionDetails");
			System.out.println("Enter 9 Exit");
			System.out.println("<---------------------------------->");

			service = new ServiceImpl();
			
			switch(sc.nextInt()) {
			case 1 :
					account = new AccountDetails();
					while(true) {
					System.out.println("Enter account Id");
					String accId = sc.next();
					if(service.accountIdValidation(accId)) {					
						account.setAcc_Id(accId);
						break;
						}else {
							System.out.println("Entered account No. is not in valid format");
							return;
						}
					}
					while(true) {
						System.out.println("Enter user name");
						String uname = sc.next();
						if(service.accountNameValidation(uname)) {				
							account.setAccHolderName(uname);
							break;
						}else {
							System.out.println("Entered Name is not in valid format");
							return;	
						}
					}
					AddressDetails address = new AddressDetails();
					
					System.out.println("Enter address: ");
					System.out.println("Enter address line1 : ");				
					address.setAddressLine1(br.readLine());
					System.out.println("Enter City ");
					address.setCity( sc.next());
					System.out.println("Enter State ");
					address.setState(br.readLine());
					
					account.setAddress(address);
					
					System.out.println("Enter deposit amount : ");
					account.setDepositAmount(sc.nextDouble());
					
					System.out.println("Do u want to enter loan details :");
					System.out.println("If 'Yes' for press 1 and 'No' for press 2");
					if(sc.nextInt()==1) {
						loan = new LoanDetails();
						System.out.println("Enter loan id :");
						loan.setLoanId(sc.next());
						System.out.println("Enter loantype (Car,Home,Education)");
						loan.setLoanTypee(LoanType.valueOf(sc.next()));
						System.out.println("Enter loan amount : ");
						loan.setLoanAmt(sc.nextDouble());
						loan.setAcc_Id(account.getAcc_Id());loan.setAccHolderName(account.getAccHolderName());
						loan.setDepositAmount(account.getDepositAmount());loan.setAddress(account.getAddress());
						service.createAccountWithLoan(loan);
						break;
					}else {
						service.createAccount(account);
						break;
					}
		
			case 2 :
					System.out.println("Enter account Id : ");
					String accId = sc.next();
					System.out.println("Enter amount : ");
					double amt = sc.nextDouble();
					double nAmt = service.depositAmount(accId, amt);
					
					System.out.println("updated balance : "+nAmt);
					break;
			case 3 :
					System.out.println("Enter account Id : ");
					String accId1 = sc.next();
					System.out.println("Enter amount : ");
					double amt1 = sc.nextDouble();
					double nAmt1 = service.withdrawAmount(accId1, amt1);
					
					System.out.println("updated balance : "+nAmt1);
					break;
			case 4 :
					System.out.println("Enter account Id : ");
					AccountDetails acc = service.getAccDetails(sc.next());
					if(acc!=null) {
					System.out.println("Account id = "+acc.getAcc_Id());
					System.out.println("Account Holder Name = "+acc.getAccHolderName());
					System.out.println("Address = [ address line 1 : "+acc.getAddress().getAddressLine1()+" , city : "+acc.getAddress().getCity()+" , state : "+acc.getAddress().getState()+" ]");
					System.out.println("Account Deposit : "+acc.getDepositAmount());
					break;
					}else {
						System.out.println("No Account Record Found!!!");
						System.out.println("Check account no.");
						break;
					}
			case 5 :
				System.out.println("Enter account Id : ");
				String getLoanId = sc.next();
				System.out.println("Enter pay amount : ");
				double getAmt = sc.nextDouble();
						
				double upAmt = service.getLoan(getLoanId, getAmt);
				System.out.println("Updated loan amount : "+upAmt);
				break;
						
			case 6 :
					System.out.println("Enter account Id : ");
					String aId = sc.next();
					System.out.println("Enter amount : ");
					double am = sc.nextDouble();
					
					double newAmt = service.payLoan(aId, am);
					System.out.println("Updated loan amount : "+newAmt);
					break;	
			case 7 :
					System.out.println("Enter account Id : ");
					LoanDetails loanDet = service.getLoanDetails(sc.next());
					if(loanDet!=null) {
						System.out.println("Account Id : "+loanDet.getAcc_Id());
						System.out.println("Loan Id : "+loanDet.getLoanId());
						System.out.println("Loan type : "+loanDet.getLoanType());
						System.out.println("Loan amount : "+loanDet.getLoanAmt());System.out.println();
						break;
					}else {
						System.out.println("Not Found Loan record!!");
						break;
					}
					
			case 8 :
					System.out.println("Enter account no. : ");
					List<TransactionDetails> trans = service.getTransactionDetails(sc.next());
					
					if(trans!=null) {
						for(TransactionDetails t : trans) {
						System.out.println("Transaction Id = "+t.getTransactionId());
						System.out.println("Transaction amt = "+t.getTransactionAmt());
						System.out.println("Transaction type = "+t.getTransactionType());
						System.out.println("Transaction Account Id = "+t.getAccountId());
						System.out.println();
						}
						break;
					}else {
						System.out.println("Wrong Account Id!!!");
						break;
					}
			case 9 :
					System.out.println("Thank you for using this application");
					sc.close();br.close();
					break;
			default :
					System.out.println("Invalid choice ");
					break;
			}
		}
        
        
    }
}

