package stateandbehavior;


public class Stack_program {
	private Stack stack;
	private RandomStringGenerator rsg;
	
	public void init(){
		stack = new Stack();
		rsg = new RandomStringGenerator();
		
	}
	public void run(){
		stack.push(rsg.getRandomString());
		stack.getSize();
		stack.push(rsg.getRandomString());
		stack.push(rsg.getRandomString());
		stack.push(rsg.getRandomString());
		stack.push(rsg.getRandomString());
		stack.push(rsg.getRandomString());
		System.out.println(stack.stringList.toString());
		stack.pop();
		stack.pop();
		System.out.println(stack.peek(2));
		System.out.println(stack.peek(0));
	}
	public static void main(String[] args) {
		Stack_program stack_program = new Stack_program();
		stack_program.init();
		stack_program.run();
	}

}
