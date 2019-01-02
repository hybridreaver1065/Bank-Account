public class SavingsAccount extends BankAccount{
	public SavingsAccount(String accName, int number, double startNum) {
		super(accName, number, startNum);
		// TODO Auto-generated constructor stub
	}


	private final double INT_RATE = .0025;
	

	public void addInterest() {
		deposit(balance  * INT_RATE);
	}
}