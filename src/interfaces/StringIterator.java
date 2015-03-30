package interfaces;

import java.util.Iterator;

public class StringIterator implements Iterator<Character> {

	private String string;
	private int i;
	
	public StringIterator(String string){
		this.string = string;
		this.i = 0;
	}
	@Override
	public boolean hasNext() {
		return this.i < this.string.length();
	}

	@Override
	public Character next() {
		return string.charAt(i++);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Støtter ikke remove");
	}

}
