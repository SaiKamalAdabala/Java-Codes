package com.kamal.JPAAssignment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;

import com.kamal.JPAAssignment.beans.AccountDetails;
import com.kamal.JPAAssignment.beans.LoanDetails;
import com.kamal.JPAAssignment.beans.TransactionDetails;
import com.kamal.JPAAssignment.beans.TransactionType;

public class DaoImpl implements Dao{
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa-Demo");
	private static EntityManager em = emf.createEntityManager();
	
	
	public void createAccount(AccountDetails acc) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(acc);
		em.getTransaction().commit();
		
	}
	public void createAccountWithLoan(LoanDetails loan) {
		// TODO Auto-generated method stub	
		em.getTransaction().begin();
		em.persist(loan);
		em.getTransaction().commit();
	}
	
	
	public AccountDetails getAccDetails(String accId) {
		// TODO Auto-generated method stub
		return em.find(AccountDetails.class, accId);
	}
	
	public LoanDetails getLoanDetails(String accId) {
		// TODO Auto-generated method stub
		return em.find(LoanDetails.class, accId);
	}
	
	
	public double depositAmount(String accId, double amt) {
		// TODO Auto-generated method stub
		AccountDetails account = em.find(AccountDetails.class, accId);
		if(account!=null) {
		System.out.println("before update : "+account.getDepositAmount());
		double temp = account.getDepositAmount()+amt;
		em.getTransaction().begin();
		account.setDepositAmount(account.getDepositAmount()+amt);
		em.getTransaction().commit();	
		TransactionDetails tran = new TransactionDetails( account, amt, TransactionType.Account_CREDIT);
		em.getTransaction().begin();
		em.persist(tran);
		em.getTransaction().commit();
		return temp;
		}
		else {
			System.out.println("Invalid account no.!!!");
			return 0;
		}
	
	}
	
	
	public double withdrawAmount(String accId, double amt) {
		// TODO Auto-generated method stub
		AccountDetails account = em.find(AccountDetails.class, accId);		
		if(account!=null) {
		System.out.println("before update : "+account.getDepositAmount());	
		em.getTransaction().begin();
		double a = account.getDepositAmount()-amt;
		account.setDepositAmount(account.getDepositAmount()-amt);
		em.getTransaction().commit();		
		TransactionDetails transaction = new TransactionDetails(account, amt, TransactionType.Account_DEBIT);
		em.getTransaction().begin();
		em.persist(transaction);
		em.getTransaction().commit();	
		return a;
		}
		else {
			System.out.println("Invalid account no.!!!");
			return 0;
		}
	
	}
	
	
	public double payLoan(String accId, double amt) {
		double updatedAmt = 0;
		LoanDetails loan = em.find(LoanDetails.class, accId);		
		if(loan!=null) {		
		em.getTransaction().begin();
		updatedAmt = loan.getLoanAmt()-amt;
		loan.setLoanAmt(loan.getLoanAmt()-amt);
		em.getTransaction().commit();	
		TransactionDetails transaction = new TransactionDetails( loan, amt, TransactionType.LOAN_DEBIT);
		em.getTransaction().begin();
		em.persist(transaction);
		em.getTransaction().commit();
		return updatedAmt;
		}
		else {
			System.out.println("This "+accId+" no. doesn't have any loan record ");
			return updatedAmt;
		}
		
	}
	public double getLoan(String loanId, double amt) {
		// TODO Auto-generated method stub
		double updatedAmt = 0;
		LoanDetails loan = em.find(LoanDetails.class, loanId);
		
		if(loan!=null) {
			em.getTransaction().begin();		
			updatedAmt = loan.getLoanAmt()+amt;
			loan.setLoanAmt(loan.getLoanAmt()+amt);
			em.getTransaction().commit();
			TransactionDetails transaction = new TransactionDetails( loan, amt, TransactionType.LOAN_CREDIT);
			em.getTransaction().begin();
			em.persist(transaction);
			em.getTransaction().commit();
			return updatedAmt;
		}else {
			System.out.println("This "+loanId+" no. doesn't have any loan record ");
			return updatedAmt;
		}
		
	}

	public List<TransactionDetails> getTransactionDetails(String accountId) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Query q = em.createQuery("select i from transaction i");		
		@SuppressWarnings("unchecked")
		List<TransactionDetails> transaction= (List<TransactionDetails>)q.getResultList();
		em.getTransaction().commit();
		return transaction;
	}
	

	
}
