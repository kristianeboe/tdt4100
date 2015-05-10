package exams.kont2014;

/**
 * Created by Kristian on 10/05/15.
 */
public class Account { private int balance = 0;

    private String accountId;
    private int maxWithdraw;

    public Account(String accountId, int maxWithdraw){
        checkAccountID(accountId);
        checkAmount(maxWithdraw);
        this.accountId = accountId;
        this.maxWithdraw = maxWithdraw;
    }

    public String getAccountId(){
        return this.accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void setMaxWithdraw(int amount){
        checkAmount(amount);
        maxWithdraw = amount;
    }

    public void deposit(int amount) {
        checkAmount(amount);
        balance += amount; }

    public void withdraw(int amount) {
        checkAmount(amount);
        if(amount > maxWithdraw){
            throw new IllegalArgumentException("Exceeds max withdraw amount, you entered "+amount);
        }
        balance -= amount; }


    protected void checkAmount(int amount){
        if(amount < 0){
            throw new IllegalArgumentException("Amount must be positive, but was "+amount);
        }
    }

    protected void checkAccountID(String accountId){
        for (int i=0;i<accountId.length();i++){
            char number = accountId.charAt(i);
            if (!Character.isDigit(number)){
                throw new IllegalArgumentException("accountId must be a string of numbers, but was "+accountId);
            }
        }
    }
}
