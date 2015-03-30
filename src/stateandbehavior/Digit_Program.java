package stateandbehavior;

public class Digit_Program {
	private Digit digit;
	
	public void init(){
		digit = new Digit(10);
	}
	public void run(){
		System.out.println(digit.getValue());
		digit.increment();
		digit.increment();
		digit.increment();
		digit.increment();
		digit.increment();
		digit.increment();
		digit.increment();
		digit.increment();
		digit.increment();
		digit.increment();
		digit.increment();
		digit.increment();
		digit.increment();
		System.out.println(digit.getValue());
		System.out.println(digit);
	}
	
	public static void main(String[] args) {
		Digit_Program digit_program = new Digit_Program();
		digit_program.init();
		digit_program.run();
	}
}
