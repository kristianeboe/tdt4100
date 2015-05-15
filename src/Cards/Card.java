package Cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kristian on 15/05/15.
 */
public class Card implements Comparable<Card> {
    private int face;
    private char suit;

    public Card(char suit, int face){
        if(suit != 'S' && suit != 'H' && suit != 'D' && suit != 'C') {
            throw new IllegalArgumentException();
        }
        if (face < 1 || face > 13){
            throw new IllegalArgumentException();
        }
        this.face = face;
        this.suit = suit;
    }

    public int getFace(){
        return face;
    }

    public char getSuit(){
        return suit;
    }

    public String toString(){
        return Character.toString(getSuit())+getFace()+"";
    }

    @Override
    public int compareTo(Card card) {
        if (this.suit == card.suit){
            return this.face - card.face;
        } else if (this.suit == 'S'){
            return 1;
        } else if(card.suit == 'S'){
            return -1;
        } else if(this.suit == 'H' && (card.suit == 'D' || card.suit == 'C')){
            return 1;
        } else if(card.suit == 'H'){
            return -1;
        } else if(this.suit == 'D') {
            return 1;
        } else{
            return -1;
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
        Collections.sort(deck, comp);
        System.out.println(deck);
    }
}
