package interfaces;

import java.util.ArrayList;

public class Person1 implements Named {
	
	private ArrayList<Integer> all;
	private String givenName;
	private String familyName;
	
	public Person1(String givenName, String familyName){
		this.givenName = givenName;
		this.familyName = familyName;
		all = new ArrayList<>();
		
	}
	
	public String toString(){
		return getFullName();
	}
	
	public String getGivenName(){
		return givenName;
	}
	public void setGivenName(String givenName){
		this.givenName = givenName;
	}
	
	public String getFamilyName(){
		return this.familyName;
	}
	
	public void setFamilyName(String familyName){
		this.familyName = familyName;
	}
	
	public String getFullName(){
		return givenName + " " + familyName;
	}
	public void setFullName(String fullName){
		int pos = fullName.indexOf(' ');
		this.givenName = fullName.substring(0, pos);
		this.familyName = fullName.substring(pos+1);
	}

}