package Cards;

import java.util.Comparator;

/**
 * Created by Kristian on 15/05/15.
 */
public class CardComparator implements Comparator<Card> {
    
    private boolean ace;
    private char trumph;
    
    public CardComparator(boolean ace, char trumph){
        this.ace = ace;
        this.trumph = trumph;
    }


    @Override
    public int compare(Card card1, Card card2) {
        if (card1.getSuit() == card2.getSuit()){
            if (ace && card1.getFace() == 1){
                return 14-card2.getFace();
            } else if(ace && card2.getFace() == 1) {
                return card1.getFace() - 14;
            } else{
                return card1.getFace() - card2.getFace();
            }
        } else if(card1.getSuit() == trumph){
            return 1;
        } else if(card2.getSuit() == trumph) {
            return -1;
        }else if (card1.getSuit() == 'S'){
            return 1;
        } else if(card2.getSuit() == 'S'){
            return -1;
        } else if(card1.getSuit() == 'H' && (card2.getSuit() == 'D' || card2.getSuit() == 'C')){
            return 1;
        } else if(card2.getSuit() == 'H'){
            return -1;
        } else if(card1.getSuit() == 'D') {
            return 1;
        } else{
            return -1;
        }
    }
}
