package encapsulation;

import java.util.Date;

public class CreditCard {
	
	private String name;
	private Date dateExpiration;
	private String cvv;
	
	public CreditCard(){
		
	}
	public void setName(String name){
		if(isValidName(name)){
			this.name = name;
		} else {
			throw new IllegalArgumentException("Invalid name!");
		}
	}
	public void setExpiration(Date expiration){
		if(isValidExpiration(expiration)){
			this.dateExpiration = expiration;
		} else {
			throw new IllegalArgumentException("Expiration date must be in the future");
		}
		
	}
	public void setCVV(String cvv){
		if(isValidCVV(cvv)){
			this.cvv = cvv;
		} else {
			throw new IllegalArgumentException("Invalid CVV");
		}
	}
	public void setNumber(String number){
		
	}
	private boolean isValidNumber(String number){
		if(number.length() != 16){
			return false;
		}
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			int digit = number.charAt(i) - '0';
			if(i % 2 == 0){
				digit = digit * 2;
				if(digit>9){
					sum += 1 + (digit + "").charAt(1)-0;
				}
			} else {
				sum += digit;
			}
		}
		return (number.charAt(15)-0)== ((sum*9)%10);
	}
	private boolean isValidCVV(String cvv){
		if(cvv.length() != 3){
			return false;
		}
		for (int i = 0; i < cvv.length(); i++) {
			char c = cvv.charAt(i);
			if(!Character.isDigit(c)){
				return false;
			}
		}
		return true;
	}
	
	private boolean isValidExpiration(Date expiration){
		return expiration.after(new Date());
	}
	
	
	private boolean isValidName(String name){
		if(name.length() > 25){
			return false;
		}
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if(! Character.isLetter(c) || c == ' ' || c == '-'){
				return false;
			}
		}
		return true;
	}
}
