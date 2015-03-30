package objectstructures;

import java.util.Stack;


public class CardHand {
	private Stack<Card> hand;
	
	public CardHand(){
		hand = new Stack<Card>();
		
	}
	
	public int getCardCount(){
		return hand.size();
	}
	
	public Card getCard(int n){
		if(n<0 || n>hand.size()){
			throw new IllegalArgumentException();
		}
		return hand.get(n);
	}
	
	public void addCard(Card card){
		hand.push(card);
	}
	
	public void play(int n){
		hand.remove(n);
	}

}
