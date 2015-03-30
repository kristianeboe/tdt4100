package stateandbehavior;
import java.util.Stack;

public class RPNCalc {
	private Stack<Double> stack;
	
	public RPNCalc(){
		stack = new Stack<Double>();
	}
	
	public void push(double n){
		stack.push(n);
	}
	public double pop(){
		return stack.pop();
	}
	public double peek(int i){
		if(i > stack.size() || i < 0){
			return Double.NaN;
		} else {
			return stack.get(stack.size()-1-i);
		}
	}
	public int getSize(){
		return stack.size();
	}
	public void performOperation(char operator){
		double secondOperand = pop();
		double firstOperand  = pop();
		double res;
		switch (operator) {
		case '+':
			res = firstOperand + secondOperand;
			break;
		case '-':
			res = firstOperand - secondOperand;
			break;
		case '/':
			if (secondOperand == 0) {
				throw new IllegalArgumentException("Can not divide by zero (0)");
			}
			res = firstOperand / secondOperand;
			break;
		case '*':
			res = firstOperand * secondOperand;
			break;
		case '~':
			push(secondOperand);
			res = firstOperand;
			break;
		case '|':
			push(firstOperand);
			res = Math.abs(secondOperand);
			break;
		case '\u03C0' + 'p':
			res = Math.PI;
			break;
		default:
			throw new IllegalArgumentException(operator + "is not a valid operator");
		}
		push(res);
	}
	
}