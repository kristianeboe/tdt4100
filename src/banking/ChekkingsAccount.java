package banking;

import java.util.ArrayList;
import java.util.Collections;

public class ChekkingsAccount implements Account {
	
	String name;
	double balance;
	
	public ChekkingsAccount(String name, double balance){
		this.name = name;
		this.balance = balance;
	}
	
	public String getName(){
		return name;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void deposit(double amount){
		balance = balance + amount;
	}
	public void withdraw(double amount){
		balance = balance - amount;
	}
	
	public String toString(){
		return name + "'s chekkings account " + balance;
	}

	public int compareTo(Account other) {
		if (this.getBalance() < other.getBalance()) {
			return 1;
		} else if(this.getBalance() > other.getBalance()){
			return -1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		SavingsAccount sa1 = new SavingsAccount("Per", 100, 0.05);
		SavingsAccount sa2 = new SavingsAccount("Kari", 50, 0.06);
		SavingsAccount sa3 = new SavingsAccount("Erik", 200, 0.06);
		ArrayList<SavingsAccount> accounts = new ArrayList<>();
		
		accounts.add(sa1);
		accounts.add(sa2);
		accounts.add(sa3);
		
		
	}
	
	

}
