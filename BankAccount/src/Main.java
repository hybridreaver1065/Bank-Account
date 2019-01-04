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
			
			//Savings Account
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
				
				accounts.add(new CheckingAccount(name, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
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
			System.out.println("Withdrawing:");
			
			int accountnumber;
			String straccountnumber;
			
				System.out.println("Account Number:");
				straccountnumber = in.nextLine();
			
				
				while (!isNumeric(straccountnumber)) {
				System.out.println("Account Number:");
				straccountnumber = in.nextLine();
				
			}
			accountnumber = (int) Double.parseDouble(straccountnumber);
			
			System.out.println("Amount:");
			double amount;
			String stramount;
			
			stramount = in.nextLine();
			while (!isNumeric(stramount)) {
				System.out.println("Amount:");
				stramount = in.nextLine();
				
				
			}
			amount = Double.parseDouble(stramount);
			
			
			
			for (BankAccount withdraws:accounts)
				if (withdraws.getAccountNum() == accountnumber) {
					//Finds the account matching
					withdraws.withdraw(amount);
					
					
					
					System.out.print(withdraws.getBalance());
				}
			
		}
		
		//If when you prompt for an account number, an invalid account number is entered, give the user the option to reenter their account number or get their account numbers(enter their name and return each of their accounts and whether it is checking or savings).  
		//You will need to use the instanceof operator to display properly.
		
		else if (transponse.toLowerCase().equals("d")){
		System.out.println("Depositing:");;
		
		double accountnumber;
		String straccountnumber;
		
			System.out.print("Account Number:");
			straccountnumber = in.nextLine();
		while (!isNumeric(straccountnumber)) {
			System.out.println("Account Number:");
			straccountnumber = in.nextLine();
		}
		accountnumber=Double.parseDouble(straccountnumber);
		

			System.out.print("Amount:");
			double amount;
			String stramount;
			
			stramount = in.nextLine();
			while (!isNumeric(stramount)) {
				System.out.print("Amount:");
				stramount = in.nextLine();
				}
			amount = Double.parseDouble(stramount);
			
			for (BankAccount deposit:accounts) {
				if (deposit.getAccountNum() == accountnumber) {
					deposit.deposit(amount);
					System.out.print(deposit.getBalance());
				}
			}
		}
		
		
		
		else if (transponse.toLowerCase().equals("t")){
			int accNumW;
			int accNumD;
			String ans = "y";
			
			System.out.print("Transfering:");
			
			int accountnumber;
			String straccountnumber;
			
				System.out.println("Account Number(Transferrer):");
				straccountnumber = in.nextLine();
			while (!isNumeric(straccountnumber)) {
				System.out.println("Account Number(Transferrer):");
				straccountnumber = in.nextLine();
				
			}
			accNumW = (int) Double.parseDouble(straccountnumber);
			in.nextLine();
			
			
			
			
			
			System.out.println("Account Number(Transferree):");
			straccountnumber = in.nextLine();
		while (!isNumeric(straccountnumber)) {
			System.out.println("Account Number(Transferree):");
			straccountnumber = in.nextLine();	
		}
		
		accNumD = (int) Double.parseDouble(straccountnumber);
		in.nextLine();
			
			
			
			

			
			
		}
		
		else if (transponse.toLowerCase().equals("g")){
			System.out.println("Getting account numbers:");
			System.out.print("Name:");
			String name = in.nextLine();
			for (BankAccount list:accounts) {
				if (list.getName().equals(name)) {
				System.out.println("The account number is:"+ list.getAccountNum());
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





	private static boolean isNumeric(String str)
	{
	try
	{
	Double.parseDouble(str);
	return true;
	}
			catch(IllegalArgumentException e)
			{
				return false;
			}
	}

}

