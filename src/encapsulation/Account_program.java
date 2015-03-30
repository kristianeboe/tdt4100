package encapsulation;

public class Account_program {
	private Account account;
	
	public void init(){
		account = new Account(100, 5);
	}
	
	public void run(){
		account.withdraw(150);
		System.out.println(account);
		account.deposit(100);
		System.out.println(account);
		System.out.println(account);
		account.addInterest();
		System.out.println(account);
	}
	
	public static void main(String[] args) {
		Account_program account_program = new Account_program();
		account_program.init();
		account_program.run();
	}

}
