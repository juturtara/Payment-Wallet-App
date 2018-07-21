package com.capgemini.walletapp.bean;

import junit.framework.TestCase;

public class WalletAppDetailsTest extends TestCase {

	WalletAppDetails details = new WalletAppDetails();

	public void testGetAccountNumber() {
		details.setAccountNumber(89654);
		assertEquals(89654, details.getAccountNumber());
	}

	public void testGetDate() {
		assertNull(details.getDate());

	}

	public void testGetAmount() {
		details.setAmount(5000);
		assertEquals(5000.0, details.getAmount());
	}

	public void testGetTid() {
		details.setTid(32165);
		assertEquals(32165, details.getTid());
	}

}
