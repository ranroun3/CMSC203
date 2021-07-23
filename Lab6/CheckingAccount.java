
public class CheckingAccount extends BankAccount {
	public static double FEE = 0.15;
	public CheckingAccount(String name, int initialAmount) {
		super(name, initialAmount);
		setAccountNumber(getAccountNumber()+"-10");
	}
	@Override
	public boolean withdraw(double amount)
	{
		boolean completed = true;
		double totalAmount=amount+FEE;
		if (totalAmount <= super.getBalance())
		{

			super.setBalance(super.getBalance()-totalAmount); ;
		}
		else
		{
			completed = false;
		}
		return completed;
	}
}
