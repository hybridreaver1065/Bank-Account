import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		
		final double OVER_DRAFT_FEE = 15;
		final double RATE = .0025;
		final double TRANSACTION_FEE = 1.5;
		final double MIN_BAL = 300;
		final double MIN_BAL_FEE = 10;
		final int FREE_TRANSACTIONS = 10;
		
		
		
		//The program should loop until the user elects to terminate.
		//Prompt the user as to whether or not they would like to add an account, make a transaction, or terminate the program?  
		boolean run = true;
		boolean terminate = false;
		
		while (run) {
		String response;
		System.out.println("Would you like to add an account(1), make a transaction(2), or terminate(3)?");
		response = in.nextLine();
		
		while (!response.equals("1") &&! response.equals("2") && !response.equals("3")) {
			System.out.println("Would you like to add an account(1), make a transaction(2), or terminate(3)?");
			response = in.nextLine();
		}
		
		if (response.equals("1")) {
			String transponse;
			System.out.println("(S)avings or (C)hecking?");
			transponse = in.nextLine();
			
			while (!transponse.toLowerCase().equals("s") &&! transponse.toLowerCase().equals("c")) {
				System.out.println("(S)avings or (C)hecking?");
				transponse = in.nextLine();
			}
			
			if (transponse.toLowerCase().equals("s")) {
				System.out.print("Making savings account, ");
				String name;

				
				System.out.print("Name:");
				name = in.nextLine();
				System.out.println("");
				
				
				
				
				accounts.add(new SavingsAccount (name, RATE, MIN_BAL, MIN_BAL_FEE));
				System.out.println("Savings Account made for "+ name );
				
				
			}
				
			else if (transponse.toLowerCase().equals("c")) {
				System.out.print("Making checking account, ");
				System.out.println("Please enter the");
				
				String name;
				System.out.print("Name:");
				name = in.nextLine();
				System.out.println("");
				
				accounts.add(new CheckingAccount(name, RATE, MIN_BAL, FREE_TRANSACTIONS));
				System.out.println("Checking Account made for "+ name );
			}
			
		//If they elect to add an account, 
		//input all necessary information including whether they would like to create a checking or savings account, 
		//then add the account to the ArrayList.
		}
			
		else if (response.equals("2")) {
				String	transponse;	
		
		
		//If the user elects to make a transaction, prompt as to whether they would like to Withdraw, deposit, transfer, or get account numbers.  
		//Use a switch case to handle the response.
			
			System.out.println("(W)ithdraw, (d)eposit, (t)ransfer, or (g)et account numbers?");
			transponse = in.nextLine();
		
			
			
			while (!transponse.toLowerCase().equals("w") &&! transponse.toLowerCase().equals("d") && !transponse.toLowerCase().equals("t") && !transponse.toLowerCase().equals("g")) {
				System.out.println("(W)ithdraw, (d)eposit, (t)ransfer, or (g)et account numbers?");
				response = in.nextLine();
			}
		
		//For deposit, withdraw and transfer, prompt the user for all necessary information and perform the transactions.   Use the Account Number to identify the account
		//Use a try catch to catch any IllegalArgumentExceptions and display the message “transaction not authorized” whenever an exception appears.
			
		if (transponse.toLowerCase().equals("w")) {
			System.out.print("Withdrawing:");
			
			System.out.println("Account Number:");
			int accountnumber= in.nextInt();
			while (!in.hasNextInt()) {
				in.nextLine();
				System.out.println("Account Number:");
				
			}
			accountnumber = in.nextInt();
			in.nextLine();
			
			
			System.out.println("Amount:");
			in.nextLine();
			while (!in.hasNextInt()) {
				in.nextLine();
				System.out.println("Amount:");
				
			}
			double amount = in.nextInt();
			in.nextLine();
			
			
			for (BankAccount withdraws:accounts)
				if (withdraws.getAccountNum() == accountnumber) {
					withdraws.withdraw(amount);
					withdraws.getBalance();
				}
			
		}
		
		//If when you prompt for an account number, an invalid account number is entered, give the user the option to reenter their account number or get their account numbers(enter their name and return each of their accounts and whether it is checking or savings).  
		//You will need to use the instanceof operator to display properly.
		
		else if (transponse.toLowerCase().equals("d")){
		System.out.print("Depositing:");
		System.out.print("Account Number:");
		int accountnumber;
		in.nextLine();
		if (in.hasNextInt()) {
			accountnumber = in.nextInt();
		}
		
		in.nextLine();
		if (in.hasNextInt()) {
			accountnumber = in.nextInt();
		}
		double amount = in.nextDouble();
		in.nextLine();
		
		
		
		}
		
		else if (transponse.toLowerCase().equals("t")){
			int accNumW;
			int accNumD;
			String ans = "y";
			
			System.out.print("Transfering:");
			System.out.print("Account Number(Transferrer):");
			
			
			while (!in.hasNextInt()) {
				String helper;
				System.out.print("Do you need help? N/Y");
				if (in.nextLine().equals("Y"))
				
				System.out.print("Account Number(Transferrer):");
				in.nextLine();

			}
			accNumW = in.nextInt();
			in.nextLine();
			System.out.print("Account Number(Tranferee):");
			while (!in.hasNextInt()) {
				in.nextLine();
			}
			accNumD = in.nextInt();
			in.nextLine();
			
			
		}
		
		else if (transponse.toLowerCase().equals("g")){
			System.out.print("Getting account numbers:");
			System.out.print("Name:");
			String name = in.nextLine();
			for (BankAccount list:accounts) {
				if (list.getName().equals(name)) {
				list.getAccountNum();
			}
			
		}
		
		}
		}
		
		
		else if (response.equals("3")) {
			//Terminate
			System.out.print("Terminating.");
			terminate = true;
			run = false;
		}
		
		
		
		
		
		
		
		
		
		//Make sure that you catch ALL exceptions.  
		//Regardless of the data entered by the user at any prompt, your program should not crash and should respond appropriately to undesired input values.
		//For example, if you ask a yes or no question, the only accepted responses should be some variation of yes or no.   
		
		if (!terminate) {
		System.out.print("Want to make another action? (Y/N)");
		String runsponse = in.nextLine();
		while (!runsponse.toUpperCase().equals("Y") && !runsponse.toUpperCase().equals("N")) {
			System.out.print("Want to make another action? (Y/N)");
			 runsponse = in.nextLine();
		}
		if (runsponse.toUpperCase().equals("N")) {
			run = false;
		}
		else {
			run = true;
		}
		
		
		}
		}
	}
}
