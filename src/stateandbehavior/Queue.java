package stateandbehavior;
import java.util.ArrayList;

public class Queue {
	ArrayList<String> queue;
	
	public Queue(){
		queue = new ArrayList<String>();
	}
	
	public void push(String str){
		queue.add(queue.size(), str);;
	}
	public String pop(){
		String str = queue.get(0);
		queue.remove(0);
		return str;
	}
	public String peek(int index){
		return queue.get(index);
	}
	public int getSize(){
		return queue.size();
	}
	public String toString(){
		return queue.toString();
	}
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.push("Hei");
		queue.push("på");
		queue.push("deg");
		System.out.println(queue.toString());
	}

}
