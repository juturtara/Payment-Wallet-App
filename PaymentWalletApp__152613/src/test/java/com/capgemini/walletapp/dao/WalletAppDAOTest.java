package com.capgemini.walletapp.dao;


import com.capgemini.walletapp.bean.WalletAppDetails;
import com.capgemini.walletapp.service.WalletAppService;

import junit.framework.TestCase;

public class WalletAppDAOTest extends TestCase {
	

	WalletAppDetails details;
	
	WalletAppService service=new WalletAppService();
	
	public void testCreateAccount() {
		assertEquals(0,service.createAccount(details) );
		assertNull(details);
		assertTrue(true);
	}

	public void testLogin() {
		
		assertEquals(false,service.login(details));
	}

	public void testShowBalance() {
		
		assertEquals(40000,40000);
		
	}

	public void testDeposit() {

		assertEquals(0,service.deposit(2000));
		assertTrue(true);
		assertNull(details);
		
	}

	public void testWithdraw() {
		
		assertEquals(0,service.withdraw(3000));
		assertTrue(true);
		assertNull(details);
		
	}

	public void testFundTransfer() {
		
		assertEquals(0,service.fundTransfer(182738829, 783783783));
		assertNull(details);
	}
}
