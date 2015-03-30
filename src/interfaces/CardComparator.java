package interfaces;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
	boolean ess;
	char trumf;
	
	public CardComparator(boolean ess, char trumf){
		this.ess = ess;
		this.trumf = trumf;
	}

	@Override
	public int compare(Card card1, Card card2) {
		if(card1.getSuit() == card2.getSuit()){
			if(card1.getFace() == card2.getFace()){
				return 0;
			} else if(card2.getFace() == 1 && ess == true){
				return -1;
			} else if(card1.getFace() == 1 && ess == true){
				return 1;
			} else if(card1.getFace() > card2.getFace()){
				return 1;
			} else {
				return -1;
			}
			} else {
			switch (card1.getSuit()) {
			case 'S':
				if(trumf == card1.getSuit()){
					return 1;
				}
				return 1;
			case 'H':
				if(trumf == card1.getSuit()){
					return 1;
				} else if(card2.getSuit()=='S'){
					return -1;
				} else {
					return 1;
				}
			case 'D':
				if(trumf == card1.getSuit()){
					return 1;
				} else if(card2.getSuit()=='S' || card2.getSuit()=='H'){
					return -1;
				} else {
					return 1;
				}
			case 'C':
				if(trumf == card1.getSuit()){
					return 1;
				}
				return -1;
				
			default:
				return 100;
			}
		}	
	}

}
