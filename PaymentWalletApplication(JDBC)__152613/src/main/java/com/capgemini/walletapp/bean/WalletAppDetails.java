package com.capgemini.walletapp.bean;

import java.time.LocalDate;
import java.util.List;

public class WalletAppDetails {
	
	private double initialBalance;
	private long accountNumber;
	private LocalDate date;
	private String branch;
	private String iFSC;
	private double amount;
	private long tid;
	private List<String> trans;
	private String accountType;

	public double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getiFSC() {
		return iFSC;
	}
	public void setiFSC(String iFSC) {
		this.iFSC = iFSC;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	public List<String> getTrans() {
		return trans;
	}
	public void setTrans(List<String> trans) {
		this.trans = trans;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "WalletAppDetails [initialBalance=" + initialBalance + ", accountNumber=" + accountNumber + ", date="
				+ date + ", branch=" + branch + ", iFSC=" + iFSC + ", amount=" + amount + ", tid=" + tid + ", trans="
				+ trans + ", accountType=" + accountType + "]";
	}
	
}
