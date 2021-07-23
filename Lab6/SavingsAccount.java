
public class SavingsAccount extends BankAccount {
	private double rate = 0.025;
	private int savingsNumber=0;
	private String accountNumber;
	public SavingsAccount(String name, double initialBalance) {
		super(name, initialBalance);
		accountNumber=super.getAccountNumber() + "-" + savingsNumber;
	}
	public void postInterest() {
		double interest = (rate/12)*super.getBalance();
		super.deposit(interest);
	}
	@Override
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	public int getSavingsNumber() {
		return savingsNumber;
	}
	public SavingsAccount(SavingsAccount oldAccount, int initialBalance) {
		super(oldAccount, initialBalance);
		savingsNumber=oldAccount.getSavingsNumber()+1;
		accountNumber= oldAccount.getAccountNumber() + "-" + savingsNumber;
	}
	
}
