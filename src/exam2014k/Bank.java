package exam2014k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kristian on 10/05/15.
 */
public class Bank {
    protected List<Account> accountList = new ArrayList<>();

    public void addAccount(Account account) {
        if (!exists(account.getAccountId())) {
            accountList.add(account);
        }

    }

    protected boolean exists(String accountId) {
        for (Account account : accountList) {
            if (account.getAccountId().equals(accountId)) {
                return true;
            }
        }
        return false;
    }

    protected int nextAccountId = 1;

    public Account createAccount() {
        while (true){
            if (!exists(nextAccountId+"")){
                Account account = new Account(nextAccountId+"",100);
                addAccount(account);
                return account;
            }
            nextAccountId++;
        }
    }

    public Account getAccount(String accountId){
        for(Account account:accountList){
            if (account.getAccountId().equals(accountId)){
                return account;
            }
        }
        return null;
    }

    protected List<Transaction> transactions = new ArrayList<>();

    public void transfer(Account source, Account target, int amount) throws IllegalArgumentException{
        if(!exists(source.getAccountId()) || !exists(target.getAccountId())) {
            throw new IllegalArgumentException("Source eller target accounten er ikke i banken");
        }
        try {
            source.withdraw(amount);
            target.deposit(amount);
            transactions.add(new Transaction(source, target, amount));
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public int getTransferSum(Account account, int year, int month) {
        int sum = 0;
        for (Transaction transaction:transactions){
            if (transaction.date.getYear() == year && transaction.date.getMonth() == month && transaction.source.equals(account)){
                sum += transaction.amount;
            }
        }
        return sum;
    }

    public void doTransactions(InputStream input){
        try (
                InputStreamReader reader = new InputStreamReader(input);
                BufferedReader bufferedReader = new BufferedReader(reader);
        ){
            while (bufferedReader.ready()){
                try {
                    String line = bufferedReader.readLine();
                    int indexOfDash = line.indexOf("-");
                    int indexOfCol = line.indexOf(":");
                    int n = line.length();
                    Account source = getAccount(line.substring(0, indexOfDash));
                    Account target = getAccount(line.substring(indexOfDash + 1, indexOfCol));
                    int amount = Integer.parseInt(line.substring(indexOfCol + 1));
                    if (source == null || target == null) {
                        continue;
                    }
                    transfer(source, target, amount);
                } catch (Exception e){

                }
            }
        } catch (IOException e){

        }
    }


}
