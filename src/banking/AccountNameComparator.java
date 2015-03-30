package banking;

import java.util.Comparator;

public class AccountNameComparator implements Comparator<SavingsAccount>{

	@Override
	public int compare(SavingsAccount o1, SavingsAccount o2) {
		int length1 = o1.getName().length();
		int length2 = o2.getName().length();
		int iterationLength = length1 > length2 ? length2 : length1;
//		int diff2 = o1.getName().compareTo(o2.getName())
		for (int i = 0; i < iterationLength; i++) {
			char ch1 = o1.getName().charAt(i);
			char ch2 = o2.getName().charAt(i);
			int diff = ch1 - ch2;
			if(diff > 0){
				return 1;
			} else if (diff < 0){
				return -1;
			}
		}
		return 0;
	}

}
