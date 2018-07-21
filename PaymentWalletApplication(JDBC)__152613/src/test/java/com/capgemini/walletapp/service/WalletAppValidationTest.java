package com.capgemini.walletapp.service;

import junit.framework.TestCase;

public class WalletAppValidationTest extends TestCase {
	WalletAppValidation v = new WalletAppValidation();

	public void testIsValidCustomerName() {
		assertEquals(false, v.isValidcustomerName(""));
		assertEquals(true, v.isValidcustomerName("Jutur"));
	}


	public void testIsValidGender() {
		assertEquals(false, v.isValidGender(""));
		assertEquals(true, v.isValidGender("Female"));
	}

	public void testIsValidPhoneNumber() {
		assertEquals(false, v.isValidphoneNumber(""));
		assertEquals(true, v.isValidphoneNumber("7238945610"));
	}

	public void testIsValidAge() {
		assertEquals(false, v.isValidAge(12));
		assertEquals(true, v.isValidAge(17));
	}

	public void testIsValidEmail() {
		assertEquals(false, v.isValidEmail(""));
		assertEquals(true, v.isValidEmail("juturtara.com"));
	}

	public void testIsValidUsername() {
		assertEquals(false, v.isValidUsername(""));
		assertEquals(true, v.isValidUsername("tara12"));
	}

	public void testIsValidPassword() {
		assertEquals(false, v.isValidPassword(""));
		assertEquals(true, v.isValidPassword("tar*123"));
	}

	public void testIsValidAmount() {
		assertEquals(false, v.isValidAmount(0));
		assertEquals(true, v.isValidAmount(1250));

	}

}
