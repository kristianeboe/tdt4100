package stateandbehavior;

public class LineEditor {
	String text;
	int insertionIndex;
	
	public LineEditor(){
		text = "TEXTEN";
		insertionIndex = 0;
	}
	
	public void left(){
		if(insertionIndex >0){
			insertionIndex--;
		}
	}
	public void right(){
		if(insertionIndex<text.length()){
			insertionIndex++;
		}
	}
	public void insertString(String s){
		String text1 = text.substring(0, insertionIndex);
		String text2 = text.substring(insertionIndex,text.length());
		text = text1.concat(s);
		text = text.concat(text2);
		insertionIndex += s.length();
	}
	public void deleteLeft(){
		if(insertionIndex>0){
		String text1 = text.substring(0, insertionIndex-1);
		String text2 = text.substring(insertionIndex,text.length());
		text = text1.concat(text2);
		insertionIndex--;
		}
		
	}
	public void deleteRight(){
		if(insertionIndex>=text.length()-2){
			text = text.substring(0,insertionIndex); 
		}else {if(insertionIndex<text.length()){
		String text1 = text.substring(0, insertionIndex+1);
		String text2 = text.substring(insertionIndex+2,text.length());
		text = text1.concat(text2);
		}
		}
	}
	public String toString(){
		return text;
	}

}
