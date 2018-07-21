package com.capgemini.walletapp.bean;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {
	
	Customer data = new Customer();

	

	public void testGetCustomerName() {
		data.setCustomerName("Tara");
		assertEquals("Tara", data.getCustomerName());
		assertTrue("Tara".equalsIgnoreCase(data.getCustomerName()));
		assertNotNull(data);
	}

	public void testGetGender() {
		data.setGender("Female");
		assertEquals("Female", data.getGender());
		assertNotNull(data);
	}

	public void testGetPhoneNumber() {
		data.setPhoneNumber("7238945610");
		assertEquals("7238945610", data.getPhoneNumber());
		assertNotNull(data);

	}

	public void testGetAge() {
		data.setAge(21);
		assertEquals(21, data.getAge());
		assertNotNull(data);
	}

	public void testGetEmail() {
		data.setEmail("juturtara@capgemini.com");
		assertEquals("juturtara@capgemini.com", data.getEmail());
		assertNotNull(data);

	}

	public void testGetUser_ID() {
		data.setUser_ID("Jutara24");
		assertEquals("Jutara24", data.getUser_ID());
		assertNotNull(data);

	}

	public void testGetPassword() {
		data.setPassword("Tara@24");
		assertEquals("Tara@24", data.getPassword());
		assertNotNull(data);

	}

}
