package com.capgemini.walletapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.walletapp.bean.Customer;
import com.capgemini.walletapp.util.DBUtil;

public class WalletAppDAO implements IWalletAppDAO {
	Connection con;
	static double d, t;
	public static ResultSet rs1;
	public static ResultSet rs2, rs3, rs4;

	public boolean createAccount(Customer customer) {
		int n1 = 0;
		int n2 = 0;

		try {

			con = DBUtil.getConnection();
			String insertquery1 = "insert into customer values(?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement pstmt1 = con.prepareStatement(insertquery1);
			pstmt1.setString(1, customer.getCustomerName());
			pstmt1.setLong(2, customer.getAadharNumber());
			pstmt1.setString(3, customer.getAddress());

			pstmt1.setString(4, customer.getPhoneNumber());
			pstmt1.setString(5, customer.getGender());
			pstmt1.setInt(6, customer.getAge());
			pstmt1.setString(7, customer.getUser_ID());
			pstmt1.setString(8, customer.getPassword());

			String insertquery2 = "insert into wallet values(?,curdate(),?,?)";
			java.sql.PreparedStatement pstmt2 = con.prepareStatement(insertquery2);
			System.out.println(customer.getWallet().getAccountNumber());
			pstmt2.setLong(1, customer.getWallet().getAccountNumber());
			pstmt2.setDouble(2, customer.getWallet().getInitialBalance());
			pstmt2.setLong(3, customer.getAadharNumber());

			n1 = pstmt1.executeUpdate();
			n2 = pstmt2.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (n1 == 1 && n2 == 1) {
			return true;
		} else
			return false;

	}

	public double showBalance() {
		try {
			java.sql.Statement stmt = con.createStatement();
			if (rs2.first()) {
				d = rs2.getDouble(3);
				return d;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	public boolean deposit(double amount) {
		try {
			if (rs2.first()) {
				
				d = rs2.getDouble(3) + amount;
				String updatequery = "update wallet set initialBalance=" + d + "where aadharNo=" + rs2.getDouble(4);
				
				String select = "select * from wallet where aadharNo =" + rs2.getDouble(4);
				java.sql.PreparedStatement stmt = con.prepareStatement(updatequery);
				int r = stmt.executeUpdate();
				rs2 = stmt.executeQuery(select);
				if (r == 1 && rs2.first()) {
					long tid = (long) (Math.random() * 1234 + 9999);
					String s = "Deposited amount " + amount + "with transactionId " + Long.toString(tid);
					String insr = "insert into transaction values('" + rs2.getLong(4) + "','" + s + "')";
					java.sql.PreparedStatement stm = con.prepareStatement(insr);
					stm.executeUpdate();
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean login(String user_ID, String password) {
		try {
			con = DBUtil.getConnection();
			java.sql.Statement stmt1 = con.createStatement();
			String selectquery1 = "select * from customer where user_ID='" + user_ID + "' and password='" + password
					+ "'";
			rs1 = stmt1.executeQuery(selectquery1);

			if (rs1.first()) {
				int k = rs1.getInt(2);
				System.out.println(k);
				java.sql.Statement stmt2 = con.createStatement();
				String selectquery2 = "select * from wallet where aadharNo=" + k;
				rs2 = stmt2.executeQuery(selectquery2);
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean withdraw(double amount) {
		try {
			if (rs2.first()) {
				System.out.println("1");
				d = rs2.getDouble(3) - amount;
				String updatequery = "update wallet set initialBalance=" + d + "where aadharNo=" + rs2.getDouble(4);
				System.out.println(updatequery);
				String select = "select *  from wallet where aadharNo =" + rs2.getDouble(4);
				java.sql.PreparedStatement stmt = con.prepareStatement(updatequery);
				int r = stmt.executeUpdate();
				rs2 = stmt.executeQuery(select);
				if (r == 1) {
					long tid = (long) (Math.random() * 1234 + 9999);
					String s = "withdrawn amount " + amount + "with transactionId " + Long.toString(tid);
					String insr = "insert into transaction values('" + rs2.getLong(4) + "','" + s + "')";
					java.sql.PreparedStatement stm = con.prepareStatement(insr);
					stm.executeUpdate();
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean fundTransfer(long receiverAccountNumber, double amount) {
		int r = 0, r1 = 0;
		try {
			String sel = "select * from wallet where accountNumber=" + receiverAccountNumber;
			java.sql.PreparedStatement smt = con.prepareStatement(sel);
			rs3 = smt.executeQuery();
			if (rs2.first()) {
				d = rs2.getDouble(3) - amount;
				String updatequery = "update wallet set initialBalance=" + d + "where aadharNo=" + rs2.getDouble(4);
				System.out.println(updatequery);
				java.sql.PreparedStatement stmt = con.prepareStatement(updatequery);

				r = stmt.executeUpdate();
				String select = "select * from wallet where aadharNo=" + rs2.getDouble(4);
				rs2 = stmt.executeQuery(select);
			}
			if (rs3.first()) {
				d = rs3.getDouble(3) + amount;
				String updatequery = "update wallet set initialBalance=" + d + "where aadharNo=" + rs3.getDouble(4);
				System.out.println(updatequery);
				java.sql.PreparedStatement stmt = con.prepareStatement(updatequery);
				r1 = stmt.executeUpdate();
			}
			if (r == 1 && r1 == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void printTrans() {
		try {

			if (rs2.first()) {
				String select = "select * from transaction where aadharNum=" + rs2.getDouble(4);
				java.sql.PreparedStatement stmt = con.prepareStatement(select);
				rs4 = stmt.executeQuery();
				while (rs4.next()) {
					System.out.println(rs4.getString("transactionInfo"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
