package com.capgemini.walletapp.service;


import com.capgemini.walletapp.bean.Customer;

public interface IWalletAppService {

	public boolean createAccount(Customer customer);

	public boolean login(String username, String password);

	public double showBalance();

	public boolean deposit(double amount);

	public boolean withdraw(double amount);

	public boolean fundTransfer(long accNo, double amount);

	public void printTrans();
	
}
