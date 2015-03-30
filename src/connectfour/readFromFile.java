package connectfour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readFromFile {
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("E:\\SkyDrive\\Java3.0\\tdt4100\\src\\connectFour.txt"));
		while(reader.ready()){
			System.out.println(reader.readLine());
		}
	}
//	FileReader reader2 = new FileReader("E:\\SkyDrive\\Java3.0\\tdt4100\\src\\connectFour.txt");
//	while(reader2.ready()){
//		System.out.println(reader2.read());
//	}

}
