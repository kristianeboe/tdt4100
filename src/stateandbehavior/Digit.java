package stateandbehavior;

public class Digit {
	int numSys;
	int digit;
	
	public Digit(int i){
		this.numSys = i;
		this.digit = 0;
	}
	public boolean increment(){
		if(this.digit==this.numSys-1){
			this.digit = 0;
			return true;
		} else {
			this.digit++;
			return false;
		}
	}
	public int getValue(){
		return this.digit;
	}
	public String toString(){
		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return ""+str.charAt(this.digit);
	}

}
