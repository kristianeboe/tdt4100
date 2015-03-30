package lotto;

import java.util.ArrayList;
import java.util.Scanner;

public class KupongSjekker {
	
	private ArrayList<ArrayList<Integer>> kupong;
	
	public KupongSjekker(String alleTall){
		kupong = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < 10; i++) {
			kupong.add(new ArrayList<Integer>());
			for (int j = 0; j < 7; j++) {
					kupong.get(i).add(Integer.parseInt(alleTall.substring(index, index+2)));
					index += 2;
				}
			}
		}
	
	private String hasWon(String vinnerTall){
		int index = 0;
		while(index < vinnerTall.length()){
			char c = vinnerTall.charAt(index);
			if (c == ' ') {
				
			}
		}
		return "";
	}
	
	public String toString(){
		String str = "";
		for (int i = 0; i < 10; i++) {
				str = str + kupong.get(i).toString() + "\n";
			}
		return str;
	}
	public static void main(String[] args) {
		KupongSjekker ks = new KupongSjekker("020307101619310306091316172402081115182134020304192128321718212327323409212"
				+ "22931323309111318232830040710233133340508091723253402030608152234");
		System.out.println(ks);
		Scanner scanner = new Scanner(System.in);
		String vinnerTall = scanner.nextLine();
		
		
		
	}
	

}
