package interfaces;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card> {
	
	CardContainer cc;
	int iterationIndex;
	
	public CardContainerIterator(CardContainer cc){
		this.cc = cc;
		this.iterationIndex = 0;
	}
	@Override
	public boolean hasNext() {
		return iterationIndex < cc.getCardCount();
	}

	@Override
	public Card next() {
		return cc.getCard(iterationIndex++);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException(); 
	}
	

}
