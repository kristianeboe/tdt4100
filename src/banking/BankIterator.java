package banking;

import java.util.Collections;
import java.util.Iterator;

public class BankIterator implements Iterator<Account> {

	private Bank bank;
	private boolean lexically;
	int iterationIndex;
	
//	public BankIterator(Bank bank, boolean lexically){
//		this.bank = bank;
//		this.lexically = lexically;
//		if(lexically){
//			Collections.sort(bank.accounts, new AccountNameComparator());
//		} else {
//			Collections.sort(bank.accounts);
//		}
//		iterationIndex = 0;
//	}
	@Override
	public boolean hasNext() {
		return iterationIndex < bank.accounts.size();
	}

	@Override
	public Account next() {
		return bank.accounts.get(iterationIndex++);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	

}
