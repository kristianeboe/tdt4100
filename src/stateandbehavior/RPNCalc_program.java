package stateandbehavior;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class RPNCalc_program {
	private RPNCalc rpnc;
	private Scanner scanner;
	
	public void init(){
		rpnc = new RPNCalc();
		scanner = new Scanner(JOptionPane.showInputDialog(null, "What you want bitch?!?!", "Bitching calculator dialog box", JOptionPane.PLAIN_MESSAGE));
	}
	public void run(){
		while(scanner.hasNext()){
			String next = scanner.next();
			try {
				double operand = Double.parseDouble(next);
				rpnc.push(operand);
			} catch (NumberFormatException e) {
				rpnc.performOperation(next.charAt(0));
			}
		}
		scanner.close();
		JOptionPane.showMessageDialog(null, rpnc.peek(0), "Yo bitch, here is your number", JOptionPane.PLAIN_MESSAGE);
	}
	public static void main(String[] args) {
		RPNCalc_program rpcp = new RPNCalc_program();
		rpcp.init();
		rpcp.run();
	}

}
