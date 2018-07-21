package com.capgemini.walletapp.bean;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {

	Customer cust = new Customer();

	public void testGetFirstName() {
		cust.setFirstName("jutur");
		assertEquals("jutur", cust.getFirstName());
		assertTrue("jutur".equalsIgnoreCase(cust.getFirstName()));
		assertNotNull(cust);

	}

	public void testGetLastName() {
		cust.setLastName("tara");
		assertEquals("tara", cust.getFirstName());
		assertTrue("tara".equalsIgnoreCase(cust.getFirstName()));
		assertNotNull(cust);

	}

	public void testGetGender() {
		cust.setGender("female");
		assertEquals("female", cust.getGender());
		assertTrue("female".equalsIgnoreCase(cust.getGender()));
		assertNotNull(cust);

	}

	public void testGetAge() {
		cust.setAge(20);
		assertEquals(20, cust.getAge());
		assertNotNull(cust);
	}

	public void testGetMobileNo() {
		cust.setMobileNo("0213654879");
		assertEquals("0213654879", cust.getMobileNo());
	}

	public void testGetEmail() {
		cust.setEmail("jutara@gmail.com");
		assertEquals("jutara@gmail.com", cust.getEmail());
	}

	public void testGetLocation() {
		cust.setLocation("hyderabad");
		assertEquals("hyderabad", cust.getLocation());
	}

	public void testGetAadhar() {
		cust.setAadhar(238674887);
		assertEquals(238674887, cust.getAadhar());
	}

}
