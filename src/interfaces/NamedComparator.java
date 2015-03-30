package interfaces;

import java.util.Comparator;

public class NamedComparator implements Comparator<Named> {
		
	public NamedComparator(){
		
	}
	
	public int compare(Named named1, Named named2){
		if(!named1.getFamilyName().equalsIgnoreCase(named2.getFamilyName())){
			return named1.getFamilyName().compareTo(named2.getFamilyName());
		} else if(named1.getGivenName().equalsIgnoreCase(named2.getGivenName())){
			return 0;
		} else {
			return named2.getGivenName().compareTo(named1.getGivenName());
		}
	}

}
