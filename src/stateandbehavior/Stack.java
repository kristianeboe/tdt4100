package stateandbehavior;
import java.util.ArrayList;

public class Stack {
	ArrayList<String> stringList;
	
	public Stack(){// constructor
		 stringList = new ArrayList<String>();
	}
	public void push(String s){
		 stringList.add(s);
	}
	public String pop(){
		if(stringList.isEmpty() != true){
			String top = stringList.get(stringList.size()-1);
			stringList.remove(stringList.size()-1);
			return top;
		} else {
			return null;
		}	
	}
	public String peek(int i){
		if(i < stringList.size() && i >= 0){
			return stringList.get(stringList.size()-1-i);
	} else {
		return null;
	}
	}
	public int getSize(){
		return stringList.size();
	}

}
