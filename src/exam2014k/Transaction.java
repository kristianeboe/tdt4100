package exam2014k;

import java.util.Date;

/**
 * Created by Kristian on 10/05/15.
 */
public class Transaction {
    public final Account source;
    public final Account target;
    public final int amount;
    public final Date date = new Date();

    public Transaction(Account source, Account target, int amount){
        this.source = source;
        this.target = target;
        this.amount = amount;
    }

}