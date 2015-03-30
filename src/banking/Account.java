package banking;

public interface Account extends Comparable<Account> {
	
	public String getName();
	
	public double getBalance();
	
	public void deposit(double amount);
	
	public void withdraw(double amount);

}
