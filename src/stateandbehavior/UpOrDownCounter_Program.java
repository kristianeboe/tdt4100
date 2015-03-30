package stateandbehavior;

public class UpOrDownCounter_Program {
	private UpOrDownCounter uodc;
	
	public void init(){
		uodc = new UpOrDownCounter(3,3);
	}
	public void run(){
		System.out.println(uodc.getCounter());
		uodc.count();
		System.out.println(uodc.getCounter());
		uodc.count();
		System.out.println(uodc.getCounter());
		uodc.count();
		System.out.println(uodc.getCounter());
		uodc.count();
		System.out.println(uodc.getCounter());
	}
	public static void main(String[] args) {
		UpOrDownCounter_Program uodcp = new UpOrDownCounter_Program();
		uodcp.init();
		uodcp.run();
	}

}
