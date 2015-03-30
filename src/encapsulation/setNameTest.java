package encapsulation;

public class setNameTest {
String name = "Ola Nordmann";
	
	private boolean isValidName(String name){
		int spacePos = name.indexOf(' ');
		if( spacePos == -1){
			return false;
		}
		int spacePosCheck = name.indexOf(' ', spacePos+1);
		String givenName = name.substring(0, spacePos);
		String familyName = name.substring(spacePos+1, name.length());
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if(!Character.isLetter(c) || spacePosCheck != -1 || givenName.length()<2 || familyName.length()<2 || c != ' '){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		setNameTest test = new setNameTest();
		System.out.println(test.isValidName(test.name));
	}
}

