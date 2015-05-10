package exams.kont2014;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kristian on 10/05/15.
 */
public class SafeBank extends Bank {
    private Map<Account, Integer> monthlyLimit;

    public SafeBank() {
        super();
        monthlyLimit = new HashMap<>();
    }

    public void setMonthlyLimit(Account account, int monthlyLimitAmount) {
        monthlyLimit.put(account, monthlyLimitAmount);
    }

    @Override
    public void transfer(Account source, Account target, int amount) {
        Date date = new Date();
        int monthlySum = super.getTransferSum(source, date.getYear(), date.getMonth());
        Integer limit = monthlyLimit.get(source);
        if (limit != null && monthlySum + amount < limit) {
            try {
                super.transfer(source, target, amount);
            } catch (Exception e) {

            }
        } else {
            throw new IllegalStateException("M limit exeeded");
        }
    }
}
