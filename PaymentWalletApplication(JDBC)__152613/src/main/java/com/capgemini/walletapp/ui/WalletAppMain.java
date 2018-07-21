package com.capgemini.walletapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.capgemini.walletapp.bean.Customer;
import com.capgemini.walletapp.bean.WalletAppDetails;
import com.capgemini.walletapp.service.WalletAppService;
import com.capgemini.walletapp.service.WalletAppValidation;

public class WalletAppMain {

	public static void createAccount() {
		WalletAppService service = new WalletAppService();
		WalletAppValidation validate = new WalletAppValidation();
		List<String> trans = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			
			System.out.println("Enter Customer Name ");
			String customerName = br.readLine();
			
			
			System.out.println("Enter  Gender(Male/Female): ");
			String gender = br.readLine();
			
			System.out.println("Enter Mobile Number: ");
			String phoneNumber = br.readLine();
			
			System.out.println("Enter Age: ");
			int age = Integer.parseInt(br.readLine());
			
			System.out.println("Enter Email: ");
			String email = br.readLine();
			
			System.out.println("Enter UserName: ");
			String username = br.readLine();
			
			System.out.println("Enter Password: ");
			String password = br.readLine();
			
			/*System.out.println("Enter the Amount: ");
			double amount = Double.parseDouble(br.readLine());*/
			
			System.out.println("enter aadhar no: ");
			long aadharNumber = Long.parseLong(br.readLine());
			
			System.out.println("enter address");
			String address = br.readLine();
			
			
			
			LocalDate date = LocalDate.now();
			
			long accountNumber = (long) (Math.random() * 123456789 + 999999999);
			Customer data = new Customer();
			
			
			WalletAppDetails details = new WalletAppDetails();
			
			
			
			data.setAadharNumber(aadharNumber);
			data.setAddress(address);
			data.setCustomerName(customerName);
			data.setGender(gender);
			data.setPhoneNumber(phoneNumber);
			data.setAge(age);
			data.setEmail(email);
			data.setUser_ID(username);
			data.setPassword(password);
			
			//details.setAmount(amount);
			System.out.println(details.getAmount());
			details.setAccountNumber(accountNumber);
			details.setTrans(trans);
			
			//details.setCust(data);
			details.setDate(date);
			data.setWallet(details);

			/*boolean isValidFName = validate.isValidFirstName(firstName);
			boolean isValidLName = validate.isValidLastname(lastName);*/
			
			boolean isValidCustName = validate.isValidcustomerName(customerName);
			
			boolean isValidgender = validate.isValidGender(gender);
			boolean isValidAge = validate.isValidAge(age);
			boolean isValidemail = validate.isValidEmail(email);
			
			if (isValidCustName && isValidgender && isValidAge && isValidemail) {
				if(service.createAccount(data))
				{
				System.out.println("Your Account has been created successfully.");
				System.out.println("Account Number is : " + details.getAccountNumber());
				}
			} else {
				System.out.println("Enter Valid Details.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	public static void login() {
		int choice = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WalletAppService service = new WalletAppService();

		try {
			
			System.out.println("Enter Username: ");
			String username = br.readLine();
			
			System.out.println("Enter Password: ");
			String password = br.readLine();

			service.login(username, password);
			System.out.println("Logged In succesfully.");
			
			do {
				System.out.println("1.ShowBalance\n2.Deposit\n3.Withdraw\n4.FundTransfer\n5.PrintTransactions\n6.Exit the Application");
				System.out.println("Enter your choice: ");
				choice = Integer.parseInt(br.readLine());
				
				switch (choice) {
				
				case 1:
					System.out.println("Your Account Balance is : " + service.showBalance());
					break;
				
				case 2:
					System.out.println("Enter the amount to deposit : ");
					double amount = Double.parseDouble(br.readLine());
					service.deposit(amount);
					break;
				
				case 3:
					System.out.println("Enter the amount to withdraw : ");
					double with_amt = Double.parseDouble(br.readLine());
					service.withdraw(with_amt);
					break;
				
				case 4:
					System.out.println("Enter any Account Number for Money Transfer: ");
					long accNo = Long.parseLong(br.readLine());
					
					System.out.println("Enter amount to Transfer: ");
					double tran_amt = Double.parseDouble(br.readLine());
					service.fundTransfer(accNo, tran_amt);
					break;
				
				case 5:
					service.printTrans();
					break;
				
				case 6:
					Menu();
					break;
				
				default:
					System.out.println("Enter valid choice.");
					break;
				}
			} while (choice != 6);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void Menu() {
		int key = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("WELCOME TO PAYMENT WALLET APPLICATION\n");
		do {
			System.out.println("MENU");
			System.out.println("1.CreateAccount\n2.Login\n3.Exit");
			System.out.println("Enter the choice: ");
			try {
				key = Integer.parseInt(br.readLine());
				switch (key) {
				case 1:
					createAccount();
					break;
				case 2:
					login();
					break;
				case 3:
					System.exit(0);
					break;

				default:
					System.out.println("Enter valid choice.");
					break;
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (key != 3);

	}

	public static void main(String[] args) {

		Menu();

	}

}
