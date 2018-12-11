
public class CheckingAccount extends BankAccount {
	private int numTransactions;
	
	final double OVER_DRAFT_FEE;
	
	final double TRANSACTION_FEE;
	
	final double FREE_TRANS;
	
	public CheckingAccount(String n,double odf, double tf, int freeTrans) {
		super(n);
		
		OVER_DRAFT_FEE = odf;
		
		TRANSACTION_FEE = tf;
		
		FREE_TRANS = freeTrans;
		
		numTransactions = 0;
	}
	
	public CheckingAccount (String n, double b, double odf, double tf, int freeTrans) {
		super(n, b);
		
		OVER_DRAFT_FEE = odf;
		
		TRANSACTION_FEE = tf;
		
		FREE_TRANS = freeTrans;
		
		numTransactions = 0;
	}
	
	public void deposit(double amt) {
		super.deposit(amt);
		
		numTransactions++;
		if (FREE_TRANS < numTransactions) {
			super.withdraw(TRANSACTION_FEE);
		}
			
	}
	
	public void withdraw(double amt) {
		if (getBalance() < 0) {
			throw new IllegalArgumentException();
		}
		else {
			super.deposit(amt);
			
			numTransactions++;
			
			if (getBalance() < 0) {
				super.withdraw(OVER_DRAFT_FEE);
			}
			if (FREE_TRANS < numTransactions) {
				super.withdraw(TRANSACTION_FEE);
			}
		}
		
	}
	
	public void transfer(double amt) {
		if (getBalance() < amt) {
			
			throw new IllegalArgumentException();
		}
		else {
			super.deposit(amt);
			
			numTransactions++;
			if (getBalance() < 0) {
				super.withdraw(OVER_DRAFT_FEE);
			}
			if (FREE_TRANS < numTransactions) {
				super.withdraw(TRANSACTION_FEE);
			}
		}
		
	}
	
}