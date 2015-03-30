package interfaces;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterationExample {
	
	private String string;
	private List<Character> characters;
	
	public void init(){
		string = "Java er gøy!";
		characters = Arrays.asList('J', 'a', 'v', 'a');
	}
	
	public void run(){
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			System.out.println(c);
		}
		
		Iterator<Character> stringIterator = new StringIterator(string);
		while (stringIterator.hasNext()) {
			char c = stringIterator.next();
			System.out.println(c);
			
		}
		
		for (int i = 0; i < characters.size(); i++) {
			char c = characters.get(i);
			System.out.println(c);
		}
	}
	
	public static void main(String[] args) {
		IterationExample ex = new IterationExample();
		ex.init();
		ex.run();
	}

}
