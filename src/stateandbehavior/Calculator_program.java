package stateandbehavior;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Calculator_program {
	private Calculator calculator;
	private Scanner scanner;
	
	public void init(){
		calculator = new Calculator();
		scanner    = new Scanner(JOptionPane.showInputDialog(null, "What do you want to calculate?", "Calculator dialog box", JOptionPane.PLAIN_MESSAGE));
	}
	public void run(){
		calculator.setFirstOperand(Double.parseDouble(scanner.next()));
		while(scanner.hasNext()){
			calculator.setOperator(scanner.next().charAt(0));
			calculator.setSecondOperand(Double.parseDouble(scanner.next()));
			calculator.setFirstOperand(calculator.calculateResult());
		}
		JOptionPane.showMessageDialog(null, (calculator.firstOperand), "Result", JOptionPane.PLAIN_MESSAGE);
	}
	public static void main(String[] args) {
		Calculator_program calc = new Calculator_program();
		calc.init();
		calc.run();
	}

}
