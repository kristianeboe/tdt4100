package encapsulation;

public class Calculator {
	private double firstOperand;
	private double secondOperand;
	private char operator;
	
	public void setFirstOperand(double firstOperand){
		this.firstOperand = firstOperand;
	}
	public void setSecondOperand(double secondOperand){
		this.secondOperand = secondOperand;
	}
	public void setOperator(char operator) {
		if(! (operator == '+' || operator == '-'|| operator == '/'|| operator == '*'|| operator == '\u0000' || operator == '%')){
			throw new IllegalArgumentException("Bla bla bla");
		}else{
			this.operator = operator;
		}
	}
	public double calculateResult(){
		double ans = 0;
		switch (operator) {
		case '+':
			ans = firstOperand + secondOperand;
			break;
		case '-':
			ans = firstOperand - secondOperand;
			break;
		case '*':
			ans = firstOperand * secondOperand;
			break;
		case '/': 
			if(secondOperand == 0){
				throw new IllegalArgumentException("Du kan ikke dele på 0!");
			} else{
				ans = firstOperand / secondOperand;				
			}
			break;
		case '%':
			ans = firstOperand % secondOperand;
			break;

		default:
			break;
		}
		return ans;
		
	}
	public double getFirstOperand(){
		return firstOperand;
	}

}
