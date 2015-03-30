package stateandbehavior;

public class UpOrDownCounter {
	int counter;
	int end;
	
	public UpOrDownCounter(int start, int end){
		if(start == end){
			throw new IllegalArgumentException("Du kan ikke sette start og end til samme verdi");
		}
		this.counter = start;
		this.end = end;
	}
	public int getCounter(){
		return counter;
	}
	public boolean count(){
		if(this.counter<this.end){
			counter++;
		} else if(this.counter>this.end){
			counter--;
		}
		if(counter == end){
			return false;
		} else {
			return true;
		}
	}

}
