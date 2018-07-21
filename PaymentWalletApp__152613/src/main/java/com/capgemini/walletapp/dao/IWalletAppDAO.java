package com.capgemini.walletapp.dao;

import java.util.List;
import java.util.Map;

import com.capgemini.walletapp.bean.WalletAppDetails;

public interface IWalletAppDAO {

	public int createAccount(WalletAppDetails details);

	public boolean login(WalletAppDetails details);

	public double showBalance();

	public int deposit(double amount);

	public int withdraw(double amount);

	public int fundTransfer(long toAccNo, double amount);

	public List<String> printTransaction();
}
