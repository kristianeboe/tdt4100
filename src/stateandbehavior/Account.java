package stateandbehavior;

public class Account {
	double balance;
	double interestRate;
	
	public Account(){
		this.balance = 0;
		this.interestRate = 5;
	}
	public String toString(){
		return "Your balance is:" + balance + "	interest rate:" + interestRate; 
	}
	public void deposit(double dep){
		if(dep > 0){
			this.balance += dep;
		}
	}
	public void addInterest(){
		 this.balance = balance + ((balance*interestRate)/100);
	}

}
