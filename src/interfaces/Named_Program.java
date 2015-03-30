package interfaces;

import java.util.ArrayList;
import java.util.Collections;

public class Named_Program {
	
	private NamedComparator comp;
	private Person1 person1;
	private Person2 person2;
	private Person1 person3;
	private Person2 person4;
	private ArrayList<Named> list;
	
	public void init(){
		comp = new NamedComparator();
		person1 = new Person1("Kristian", "Elset");
		person2 = new Person2("Bruce Wayne");
		person3 = new Person1("Moritz", "Munch");
		person4 = new Person2("Peter Parker");
		list = new ArrayList<Named>();
		
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.add(person4);
		
	}
	public void run(){
		System.out.println(list);
		Collections.sort(list, comp);
		System.out.println(list);
		
	}
	
	public static void main(String[] args) {
		Named_Program np = new Named_Program();
		np.init();
		np.run();
	}

}
