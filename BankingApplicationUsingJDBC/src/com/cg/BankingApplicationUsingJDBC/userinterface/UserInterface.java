package com.cg.BankingApplicationUsingJDBC.userinterface;

import java.util.Scanner;

import com.cg.BankingApplicationUsingJDBC.beans.AccountDetails;
import com.cg.BankingApplicationUsingJDBC.beans.LoanDetails;
import com.cg.BankingApplicationUsingJDBC.beans.LoanTypeDetails;
import com.cg.BankingApplicationUsingJDBC.beans.TransactionDetails;
import com.cg.BankingApplicationUsingJDBC.service.BankingApplicationService;
import com.cg.BankingApplicationUsingJDBC.service.BankingApplicationServiceImpl;

public class UserInterface {

	public static void main(String[] args) throws Exception {
		
		TransactionDetails account =null;
		
		BankingApplicationService service = null;
		
		service = new BankingApplicationServiceImpl();
		
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("Choose any one");
			System.out.println("Enter 1 for Create account");
			System.out.println("Enter 2 for Deposit");
			System.out.println("Enter 3 for Withdraw");
			System.out.println("Enter 4 for ShowAccountDetails");
			System.out.println("Enter 5 for GetLoan");
			System.out.println("Enter 6 for PayLoan");
			System.out.println("Enter 7 for ShowLoanDetails");
			System.out.println("Enter 8 Exit");
			switch(scan.nextInt()) {
			
			//createAccount
			case 1 :
					account = new TransactionDetails();
					while(true) {
					System.out.println("Enter account Id");
					String accId = scan.next();
					if(service.validateAccountId(accId)) {	
						account.setAccountId(accId);
						break;
						}else {
							System.out.println("Entered account No. is not in valid format");
							return;
						}
					}		//accountID
					
					while(true) {
						System.out.println("Enter user name");
						String uname = scan.next();
						if(service.validateAccountName(uname)) {
							account.setAccountName(uname);
							break;
						}else {
							System.out.println("Entered Name is not in valid format");
							return;	
						}
					}		//accountName
					System.out.println("Enter address: ");

					account.setAddres(scan.next());
					
					System.out.println("Enter deposit amount");
					account.setDepositAmount(scan.nextInt());
					
					System.out.println(" Applying Loans...");
					System.out.println("1 for Yes \n 2 for No :");
					int ch = scan.nextInt();
					if(ch==1) {
						System.out.println("Enter loanId");
						account.setLoanId(scan.nextInt());
						System.out.println("Enter loan Type \n Home\t Car \t  Education");
						System.out.println("Loan Type must be any of three");
						account.setLoanType(LoanTypeDetails.valueOf(scan.next()));		
						
						System.out.println("Enter loan amount");
						account.setLoanAmount(scan.nextInt());
						
					}
					System.out.println("Account is created");
					service.createAccount(account);break;
				
					
					//deposit
			case 2:
					System.out.println("Enter accountId :");
					String accId = scan.next();
					System.out.println("Enter amount :");
					int amt = scan.nextInt();
					int bal=service.depositAmount(accId, amt);
					System.out.println("New balance :"+bal);
					break;
					
					
					//withdraw
			case 3:
					System.out.println("Enter accountId :");
					String accIdw = scan.next();
					System.out.println("Enter amount :");
					int amtw = scan.nextInt();
					int balw=service.withdrawAmount(accIdw, amtw);
					System.out.println("New balance :"+balw);
					break;
					
					
					//showaccountdetails
					
			case 4:
					System.out.println("Enter AccountId :");
					String acnt = scan.next();
					AccountDetails act = service.showAccountDetails(acnt);
					if(act!=null) {
						System.out.println("Account Id : "+act.getAccountId());
						System.out.println("Account Name : "+act.getAccountName());
						System.out.println("Account holder address : "+act.getAddress());
						System.out.println("Deposit Amount : "+act.getDepositAmount());System.out.println();
						break;
					}else {
						System.out.println("Not found");
						break;
					}
					
					
					//getloan
			case 5:
					System.out.println("Enter amount of loan: ");
					int lamt = scan.nextInt();
					System.out.println("Enter loanId : ");
					int lid = scan.nextInt();
					int lbal = service.getLoan(lid, lamt);
					System.out.println(lbal+" loan amount got");
					break;
			
					
					//payloan
			case 6:
					System.out.println("Enter amount : ");
					int plamt = scan.nextInt();
					System.out.println("Enter loanId : ");
					int plid = scan.nextInt();
					int plbal = service.payLoan(plid, plamt);
					System.out.println("paid loan amount "+plbal);
					break;
					
					
					
					//showloandetails
			case 7:
					System.out.println("Enter loanId : ");
					int lId = scan.nextInt();
					LoanDetails loan = service.showLoanDetails(lId);
					if(loan!=null)
						System.out.println("Loan Id = "+loan.getLoanId()+" Loan type = "+loan.getLoanType()+" Loan Amount = "+loan.getLoanAmount());
					else
						System.out.println("loanId not matched");
					
					break;
					
					
					//exit
					
			case 8:
					System.out.println("Thank you!");
					scan.close();
					break;
			}
		}

		

	}

}
