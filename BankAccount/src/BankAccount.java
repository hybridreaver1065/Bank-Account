
public class BankAccount {
	static int nextAccNum;
	private String name;
	private int acctNum;
	private double balance;
	
	public BankAccount(String n) {
		name = n;
		balance = 0;
		acctNum = nextAccNum;
		nextAccNum ++;
	}
	
	public BankAccount (String n, double b) {
		name = n;
		balance = b;
		acctNum = nextAccNum;
		nextAccNum ++;
	}

	public void deposit(double amt) {
			balance += amt;
		
		}
		



	public void withdraw(double amt) {
		if (amt < 0){
		balance -= amt;
		}
	
	}


	public String getName() {
		return name;
		
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String toString() {
		return ""+acctNum+" "+ name+ " "+ balance+ "";
	}

}
