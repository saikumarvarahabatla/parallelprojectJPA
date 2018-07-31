package com.cg.mypayment.junittest;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.SQLException;


import org.junit.Before;
import org.junit.Test;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;
import com.cg.mypaymentsapp.exception.InvalidInputException;

public class TestClass {
WalletService service;
	
	@Before
	public void initData(){
		 Customer cust1=new Customer("sai", "8341730575",new Wallet(new BigDecimal(9000)));
		 Customer cust2=new Customer("vamsi", "9652119965",new Wallet(new BigDecimal(6000)));
		 Customer cust3=new Customer("sanjeev", "8142549030",new Wallet(new BigDecimal(7000)));
				
		
			service= new WalletServiceImpl();
			
	}
	
	@Test
	public void testShowBal() throws SQLException {
		Customer customer1= new Customer();
		customer1=service.showBalance("8341730575");
		String bal = customer1.getWallet().getBalance().toString();
		assertEquals("9000",bal);
	}
	
	@Test (expected=NullPointerException.class)
	public void testCreateAccount() {
		try {
			service.createAccount(null, null, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateAccount2() {
		Customer cust = new Customer();
		try {
			cust=service.createAccount("Vamshi", "8568745614", new BigDecimal(4500));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Vamshi",cust.getName());
	}
	
	@Test
	public void testCreateAccount3() {
		Customer cust = new Customer();
		try {
			cust=service.createAccount("Vamshi", "8568745614", new BigDecimal(4500));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("8568745614",cust.getMobileNo());
		
	}
	
	@Test (expected=InvalidInputException.class)
	public void testShowBalance() throws SQLException {
		Customer cust = new Customer();
		cust = service.showBalance("9875210023");
	}
	
	@Test
	public void testShowBalance2() throws SQLException {
		Customer cust = new Customer();
		
		cust = service.showBalance("9900112212");
		//assertEquals(cust.getWallet().getBalance(), new Wallet(new BigDecimal(9000)));
	}
	
	
}
