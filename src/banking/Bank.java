package banking;

import java.util.ArrayList;

public class Bank {
	
	ArrayList<Account> accounts;
	
	public Bank(){
		accounts = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		SavingsAccount sa1 = new SavingsAccount("Per", 100, 0.05);
		SavingsAccount sa2 = new SavingsAccount("Kari", 50, 0.06);
		ChekkingsAccount ca1 = new ChekkingsAccount("Tord", 20);
		ChekkingsAccount ca2 = new ChekkingsAccount("Berit", 60);
		
		Bank bank = new Bank();
		bank.accounts.add(sa1);
		bank.accounts.add(sa2);
		bank.accounts.add(ca1);
		bank.accounts.add(ca2);
		
		System.out.println(bank.accounts);
	}

}
