package encapsulation;

import java.util.Date;
import java.util.regex.Pattern;

public class Person {
	private String name;
	private String email;
	private Date birthday = new Date();
	private char gender;
	
	public void setName(String name){
		if(!isValidName(name)){
			throw new IllegalArgumentException("Det er noe galt med navnet");
		} else {
			this.name = name;
		}
	}
	public String getName(){
		return this.name;
	}
	public void setEmail(String email){
		int dotPos = email.indexOf('.');
		int atPos = email.indexOf('@');
		if(!(email.substring(0, dotPos).equalsIgnoreCase(this.name.substring(0,dotPos)) && email.substring(dotPos+1, atPos).equalsIgnoreCase(this.name.substring(dotPos+1,atPos)))){
			throw new IllegalStateException("Feltet name og fornavn.etternavn i eposten er ikke det samme");
		} else if(isValidEmail(email)){			
			this.email = email;
		} else {
			throw new IllegalArgumentException("Dette er ikke en valid email");
		}
	}
	public String getEmail(){
		return this.email;
	}
	public void setBirthday(Date birthday){
		if(isValidBirthday(birthday)){
			this.birthday = birthday;
		} else {
			throw new IllegalArgumentException("Feil format på birthday");
		}
	}
	public Date getBirthday(){
		return this.birthday; 
	}
	
	public void setGender(String gender){
		if(isValidGender(gender.charAt(0))){
			this.gender = gender.charAt(0);
		} else {
			throw new IllegalArgumentException(gender + " er ikke et gyldig format");
		}
		
	}
	public char getGender(){
		return this.gender;
	}
	private boolean isValidGender(char gender){
		if(gender != 'M' || gender != 'F' || gender != '\0' || gender == ' '){
			return false;
		} else {
			return true;
		}
	}
	private boolean isValidBirthday(Date birthday){
		if(this.birthday.after(birthday)){
			return true;
		}
		return false;
	}
	private boolean isValidName(String name){
		int spacePos = name.indexOf(' ');
		if( spacePos == -1){
			return false;
		}
		int spacePosCheck = name.indexOf(' ', spacePos+1);
		String givenName = name.substring(0, spacePos);
		String familyName = name.substring(spacePos+1, name.length());
		if(givenName.length()<2 || familyName.length()<2 || spacePosCheck != -1){
			return false;
		}
		for (int i = 0; i < givenName.length(); i++) {
			char c = givenName.charAt(i);
			if(!Character.isLetter(c)){
				return false;
			}
		}
		for (int j = 0; j < familyName.length(); j++) {
			char c = familyName.charAt(j);
			if(!Character.isLetter(c)){
				return false;
			}
		}
		return true;
	}
	private boolean isValidEmail(String email){
		boolean res = false;
		int dotPos = email.indexOf('.');
		int atPos = email.indexOf('@');
		int dot2Pos = email.indexOf(dotPos+1,'.');
		String checkGivenName = email.substring(0, dotPos);
		String checkFamilyName = email.substring(dotPos+1,atPos);
		String domene = email.substring(atPos+1, dot2Pos);
		String CC = email.substring(dot2Pos+1,email.length());
		if(email != null && checkGivenName.length()>2 && checkFamilyName.length()>2 && CC.length()>1 && CC.length()<4){
			res = true;
			for (int i = 0; i < email.length(); i++) {
				char c = email.charAt(i);
				if(!Character.isLetter(c) || c != '@' || c != '.'){
					return false;
				}
			}
			return res;
		}
		return false;
	}
	private String getGivenName(){
		int dotPos = name.indexOf('.');
		return name.substring(0,dotPos);
	} 
	private String getFamilyName(){
		int dotPos = name.indexOf('.');
		return name.substring(dotPos + 1);
	}
}