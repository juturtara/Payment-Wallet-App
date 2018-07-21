package com.capgemini.walletapp.bean;

import java.time.LocalDate;

import com.capgemini.walletapp.bean.WalletAppDetails;

import junit.framework.TestCase;

public class WalletAppDetailsTest extends TestCase {

	WalletAppDetails details=new WalletAppDetails();
	
	public void testGetAccNo() {
		
		details.setAccNo(1234567890);
		assertEquals(1234567890, details.getAccNo());
		assertFalse(details.getAccNo()==1987654321);
		assertTrue(details.getAccNo()==1234567890);
	
	}

	public void testGetDate() {

		assertNotNull(details);
		details.setDate(LocalDate.now());
		
		assertEquals(LocalDate.now(),details.getDate());
		
	}

	public void testGetUsername() {
		
		assertNotNull(details);
		details.setUsername("tara");
		
		assertEquals("tara", details.getUsername());
		assertTrue(details.getUsername().equals("Lubna"));
		assertFalse(details.getUsername().equals("John"));
		
	}

	public void testGetPassword() {
		
		assertNotNull(details);
		details.setPassword("lubna1234");
		
		assertEquals("Roy", details.getPassword());
		assertTrue(details.getPassword().equals("lubna1234"));
		assertFalse(details.getPassword().equals("john1234"));
		
	}

	public void testGetBalance() {

		assertNotNull(details);
		details.setBalance(50000);
		
		assertEquals(50000,details.getBalance());
		assertTrue(details.getBalance()==50000);
		assertFalse(details.getBalance()==40000);
		

		
	}

	public void testGetCustomer() {
		
		assertNull(details.getCustomer());
		
	}

	public void testGetTransId() {
		
		assertNull(details.getTransId());
		
	}

	public void testGetBranch() {
		
		details.setBranch("hyderabad");
		
		assertEquals("hyderabad",details.getBranch());
		assertTrue(details.getBranch().equals("hyderabad"));
		assertFalse(details.getBranch().equals("secunderabad"));
	}

	public void testGetAccType() {
		
		details.setAccType("savings");
		
		assertEquals("savings", details.getAccType());
		assertTrue(details.getAccType().equals("savings"));
		assertTrue(details.getAccType().equals("current"));
		
	}

}


