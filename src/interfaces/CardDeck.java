package interfaces;

import java.util.Iterator;
import java.util.Stack;

public class CardDeck implements CardContainer{
	private Stack<Card> cardDeck;
	
	public CardDeck(int n){
		cardDeck = new Stack<Card>();
		
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < n+1; j++) {
				switch (i) {
				case 1:
					cardDeck.push(new Card('S',j));
					break;
				case 2:
					cardDeck.push(new Card('H',j));
					break;
				case 3:
					cardDeck.push(new Card('D',j));
					break;
				case 4:
					cardDeck.push(new Card('C',j));
					break;
				default:
					break;
				}
			}
		}
	}
	
	public String toString(){
		return cardDeck.toString();
	}
	
	
	public int getCardCount(){
		return cardDeck.size();
	}
	
	public Card getCard(int n){
		if(n<0 || n>cardDeck.size()){
			throw new IllegalArgumentException();
		}
		return cardDeck.get(n);
	}
	
	public void deal(CardHand hand, int n){
		for (int i = 0; i < n; i++) {
			hand.addCard(cardDeck.pop());
		}
		
	}
	
	public void shufflePerfectly(){
		int n = cardDeck.size()/2;
		Stack<Card> half1 = new Stack<Card>();
		Stack<Card> half2 = new Stack<Card>();
		for (int j = 0; j < n*2; j++) {
			if( j < n){
				half1.push(cardDeck.get(j));
			} else {
				half2.push(cardDeck.get(j));
			}
		}
		cardDeck.removeAllElements();
		int i = 0;
		while(cardDeck.size()<n*2){
			if(i%2 == 0){
				cardDeck.push(half1.get(0));
				half1.remove(0);
			} else {
				cardDeck.push(half2.get(0));
				half2.remove(0);
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		CardDeck cd = new CardDeck(4);
		System.out.println(cd.cardDeck.get(0).toString());
		cd.shufflePerfectly();
		System.out.println(cd);
	}

	@Override
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}

}
