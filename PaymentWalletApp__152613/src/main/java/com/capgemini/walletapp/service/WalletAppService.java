package com.capgemini.walletapp.service;

import java.util.List;

import com.capgemini.walletapp.bean.WalletAppDetails;
import com.capgemini.walletapp.dao.WalletAppDAO;

public class WalletAppService implements IWalletAppService {

	WalletAppDAO dao=new WalletAppDAO();
	
	public int createAccount(WalletAppDetails details) {
		// TODO Auto-generated method stub
		return dao.createAccount(details) ;
		
	}

	public int deposit(double amount) {
		// TODO Auto-generated method stub
		return dao.deposit(amount);
	}

	public int withdraw(double amount) {
		// TODO Auto-generated method stub
		return dao.withdraw(amount);
	}

	public int fundTransfer(long toAccNo,double amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(toAccNo, amount);
	}

	public boolean login(WalletAppDetails details) {
		// TODO Auto-generated method stub
		return dao.login(details);
		
	}

	public double showBalance() {
		// TODO Auto-generated method stub
		return dao.showBalance();
	}

	public List<String> printTransaction() {
		// TODO Auto-generated method stub
		return dao.printTransaction();
	}

	
}
