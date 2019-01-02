//@Author Jacob Mingis le Period de Seventh
public class BankAccount {

	//Fields
	private String name;
	double balance = 0;
	private int accNum = 0;
	//Constructors
	

	public BankAccount(String accName,int number) {
			
		balance = 0;
		accNum =  number;
		name = accName;
	}
	public BankAccount(String accName,int number, double startNum ) {
		
		balance = startNum;
		name =  accName;
		accNum = number;
		
		
	}
	//Methods
	
	
	//Deposit
	public void deposit(double deposit) {
		
		balance += deposit;
		
	}
	//Withdraw
	public void withdraw(double withdraw) {
		balance -= withdraw;
		
	}
	//String
	public String toString() {

		return "name:"+name+"\t balance:"+ balance+"\t Account Number:"+accNum;
	
	}
	//Gets
	public String getName() {
		return name;
	}
	public int getAccountNum() {
		return accNum;
	}public double Balance() {
		return balance;
	}
}


