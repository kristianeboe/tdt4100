package Cards;

import java.util.ArrayList;

/**
 * Created by Kristian on 15/05/15.
 */
public class CardHand extends CardDeck {

    public CardHand(){
        super(0);
    }

    public void addCard(Card card){
        cardDeck.add(card);
    }

    public Card play(int n){
        if (n<0 || n > getCardCount()){
            throw new IllegalArgumentException();
        }
        Card card = cardDeck.get(n);
        cardDeck.remove(card);
        return card;
    }
}
