
public class SavingsAccount extends BankAccount {

	private double intRate;
	
	final double MIN_BAL;
	
	final double MIN_BAL_FEE;
	
	public SavingsAccount(String n, double r, double mb, double mbf) {
		super(n);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	
	public SavingsAccount(String n, double b,  double r, double mb, double mbf) {
		super(n, b);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	
	public void withdraw(double amt) {
		if (amt > super.getBalance()) {
			throw new IllegalArgumentException();
			//If not allowed to occur throw an IllegalArgumentException
		}
		else {
			
			super.withdraw(amt);
		}
	}
	public void transfer(BankAccount other, double amt) {
		if (other.equals(this)) {//transfer money to other account only if the accounts are both in the same name.
			if (amt > super.getBalance() ) {
				
				throw new IllegalArgumentException();
				//balance cannot go negative.  **if a transaction is not allowed to occur, throw an IllegalArgumentException
			}
			else {
			withdraw(amt);
			other.deposit(amt);
			}
		}
		
	//Transaction fee would apply when transferred to a checking account.
	
	}
	
	public void addInterest() {
		super.deposit(super.getBalance() *intRate);
	}
	public void endOfMonthUpdate() {
		super.deposit(super.getBalance() *intRate);
	}
}
