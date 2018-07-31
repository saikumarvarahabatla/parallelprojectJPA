package com.cg.mypaymentapp.repo;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.mypaymentapp.beans.Customer;

public class WalletRepoImpl implements WalletRepo {


	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction trans;

	public WalletRepoImpl() {
		super();
		emf=Persistence.createEntityManagerFactory("Parallelproject_JPA");
		em=emf.createEntityManager();
		trans=em.getTransaction();
	
	}

	@Override
	public boolean save(Customer customer) {
		if(customer!=null){
		trans.begin();
		em.persist(customer);
		trans.commit();
		
		return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public Customer findOne(String mobileNo) throws SQLException {
		trans.begin();
		Customer customer=em.find(Customer.class,mobileNo);
		trans.commit();
		return customer;
		}

	@Override
	public void update(Customer customer) throws SQLException {

		trans.begin();
		em.persist(customer);
		trans.commit();
	}

}