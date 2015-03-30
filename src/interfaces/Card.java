package interfaces;

import java.util.ArrayList;
import java.util.Collections;

public class Card implements Comparable<Card>{
	private char color;
	private int value;
	
	public Card(char color, int value){
		String valid = "SHDC";
		if(valid.indexOf(color) != -1 && value > 0 && value < 14){
			this.color = color;
			this.value = value;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public char getSuit(){
		return color;
	}
	public int getFace(){
		return value;
	}
	public String toString(){
		String str = ""; 
		str = Character.toString(color)+Integer.toString(value);
		return str;
	}

	@Override
	public int compareTo(Card card2) {
		if(this.getSuit() == card2.getSuit()){
			if(this.getFace() > card2.getFace()){
				return 1;
			} else if(this.getFace() == card2.getFace()){
				return 0;
			} else {
				return -1;
			}
		} else {
			switch (this.getSuit()) {
			case 'S':
				return -1;
			case 'H':
				if(card2.getSuit()=='S'){
					return 1;
				} else {
					return -1;
				}
			case 'D':
				if(card2.getSuit()=='S' || card2.getSuit()=='H'){
					return 1;
				} else {
					return -1;
				}
			case 'C':
				return 1;
				
			default:
				return 100;
			}
		}
	}
	
	public static void main(String[] args) {
		CardComparator comp = new CardComparator(true, 'D');
		Card c6 = new Card('H', 3);
		Card c2 = new Card('S', 2);
		Card c5 = new Card('S', 3);
		Card c3 = new Card('S', 4);
		Card c7 = new Card('H', 4);
		Card c14 = new Card('C', 3);
		Card c1 = new Card('S', 1);
		Card c4 = new Card('H', 1);
		Card c8 = new Card('D', 1);
		Card c9 = new Card('D', 2);
		Card c16 = new Card('H', 2);
		Card c13 = new Card('C', 2);
		Card c11 = new Card('D', 4);
		Card c15 = new Card('C', 4);
		Card c10 = new Card('D', 3);
		Card c12 = new Card('C', 1);
		ArrayList<Card> deck = new ArrayList<>();
		deck.add(c1);
		deck.add(c2);
		deck.add(c3);
		deck.add(c4);
		deck.add(c5);
		deck.add(c6);
		deck.add(c7);
		deck.add(c8);
		deck.add(c9);
		deck.add(c10);
		deck.add(c11);
		deck.add(c12);
		deck.add(c13);
		deck.add(c14);
		deck.add(c15);
		deck.add(c16);
		System.out.println(deck);
		Collections.sort(deck, comp);;
		System.out.println(deck);
	}

}
