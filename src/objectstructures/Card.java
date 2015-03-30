package objectstructures;

public class Card {
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
	
	public static void main(String[] args) {
		Card c = new Card('S', 1);
		System.out.println(c);
	}

}
