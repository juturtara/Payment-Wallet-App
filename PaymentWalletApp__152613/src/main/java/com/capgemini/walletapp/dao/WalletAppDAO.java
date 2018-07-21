package com.capgemini.walletapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.capgemini.walletapp.bean.WalletAppDetails;

public class WalletAppDAO implements IWalletAppDAO {
	long transId;
	static WalletAppDetails temp = new WalletAppDetails();
	static List<WalletAppDetails> list = new ArrayList<WalletAppDetails>();

	// static Map<Long,String> transactions=new HashMap<Long,String>();

	public int createAccount(WalletAppDetails details) {

		if (list.add(details)) {
			temp = details;
			return 1;
		} else
			return 0;
	}

	public boolean login(WalletAppDetails details) {

		Iterator<WalletAppDetails> it = list.iterator();
		while (it.hasNext()) {

			WalletAppDetails itDetails = it.next();
			if (details.getUsername().equals(itDetails.getUsername())
					&& details.getPassword().equals(itDetails.getPassword())) {
				temp = itDetails;
				return true;
			}
		}
		return false;
	}

	public double showBalance() {

		Iterator<WalletAppDetails> it = list.iterator();
		while (it.hasNext()) {

			WalletAppDetails itDetails = it.next();
			if (temp.getUsername().equals(itDetails.getUsername())) {

				double balance = itDetails.getBalance();
				return balance;
			}

		}
		return 0;
	}

	public int deposit(double amount) {

		Iterator<WalletAppDetails> it = list.iterator();
		while (it.hasNext()) {

			WalletAppDetails itDetails = it.next();

			if (temp.getUsername().equals(itDetails.getUsername())) {

				itDetails.setBalance(itDetails.getBalance() + amount);
				// set transaction
				transId = (long) (Math.random() * 12345 + 678);
				String s = Long.toString(transId) + ":\tDeposited "
						+ Double.toString(amount) + " to "
						+ Long.toString(itDetails.getAccNo()) + " Balance: "
						+ itDetails.getBalance();
				itDetails.getTransId().add(s);

				// transactions.put(transId, s);
				return 1;
			}

		}
		return 0;
	}

	public int withdraw(double amount) {

		Iterator<WalletAppDetails> it = list.iterator();
		while (it.hasNext()) {

			WalletAppDetails itDetails = it.next();
			if (temp.getUsername().equals(itDetails.getUsername())) {

				itDetails.setBalance(itDetails.getBalance() - amount);
				// set transaction
				transId = (long) (Math.random() * 10000 + 999);
				String s = Long.toString(transId) + ":\tWithdrew "
						+ Double.toString(amount) + " from "
						+ Long.toString(itDetails.getAccNo()) + " Balance: "
						+ itDetails.getBalance();
				itDetails.getTransId().add(s);
				// transactions.put(transId, s);
				return 1;
			}

		}
		return 0;
	}

	public int fundTransfer(long toAccNo, double amount) {

		Iterator<WalletAppDetails> it = list.iterator();
		Iterator<WalletAppDetails> it1 = list.iterator();
		while (it.hasNext()) {

			WalletAppDetails itDetails = it.next();
			if (temp.getUsername().equals(itDetails.getUsername())) {
				
				transId = (long) (Math.random() * 12345 + 234);
				itDetails.setBalance(itDetails.getBalance() - amount);
				

				while (it1.hasNext()) {

					WalletAppDetails itDetails1 = it1.next();
					if (itDetails1.getAccNo() == toAccNo) {

						itDetails1.setBalance(itDetails1.getBalance() + amount);
						String s1 = Long.toString(transId) + "Recieved :"
								+ Double.toString(amount) + " from "
								+ Long.toString(itDetails.getAccNo())
								+ "\t Balance :" + itDetails1.getBalance();
						itDetails1.getTransId().add(s1);
					}

				}

				String s = Long.toString(transId) + ":\tTransfered "
						+ Double.toString(amount) + " to "
						+ Long.toString(toAccNo) + " from "
						+ Long.toString(itDetails.getAccNo()) + " Balance :"
						+ itDetails.getBalance();
				itDetails.getTransId().add(s);
			
				return 1;
			}
		}
		return 0;
	}

	public List<String> printTransaction() {

		Iterator<WalletAppDetails> it = list.iterator();
		while (it.hasNext()) {

			WalletAppDetails itDetails = it.next();
			if (temp.getUsername().equals(itDetails.getUsername())) {

				return itDetails.getTransId();

			}

		}
		return null;
	}

}
