package encapsulation;

public class Account {
	private double balance;
	private double interestRate;
	
	public Account(double balance, double interestRate){
		if(isValidNumber(balance) && isValidNumber(interestRate)){
			this.balance = balance;
			this.interestRate = interestRate;
		} else {
			throw new IllegalArgumentException(" Du må konstruere klassen med positive verdier");			
		}
	}
	public String toString(){
		return "Your balance is:" + balance + "	interest rate:" + interestRate; 
	}
	public void deposit(double dep){
		if(isValidNumber(dep)){
			this.balance += dep;
		} else {
			throw new IllegalArgumentException("Du må sette inn et positivt tall!");
		}
	}
	public void addInterest(){
		 this.balance = balance + ((balance*interestRate)/100);
	}
	public void setInterestRate(double interestRate){
		if(isValidNumber(interestRate)){
			this.interestRate = interestRate;
		} else {
			throw new IllegalArgumentException();
		}
	}
	public void withdraw(double amount){
		if(!isValidNumber(amount)){
			throw new IllegalArgumentException("Du kan ikke ta ut en negativ amount");
		} else if(balance < amount){
			throw new IllegalStateException("Operasjonen gir ugyldig tilstand");
		} else {
			balance = balance - amount;
		}
	}
	
	public double getInterestRate(){
		return interestRate;
	}
	public double getBalance(){
		return balance;
	}
	private boolean isValidNumber(double number){
		if(number > 0 ){
			return true;
		} else {
			return false;
		}
	}
}
