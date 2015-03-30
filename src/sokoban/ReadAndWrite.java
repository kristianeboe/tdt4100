package sokoban;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadAndWrite {

	public String readFromFile(String fileName, String location)
			throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(location
				+ fileName + ".txt"));
		String newBoardString = "";
		while (reader.ready()) {
			newBoardString = newBoardString + reader.readLine();
		}
		reader.close();
		return newBoardString;
	}

	public void writeToFile(String board) throws IOException {
		String str = "SokobanAoutoSave";
		PrintWriter writer = new PrintWriter(str + ".txt");
		writer.println(board);
		writer.close();
	}

	public static void main(String[] args) {
		ReadAndWrite rw = new ReadAndWrite();
		String str = "";
		String location = "C:\\Users\\Kristian\\SkyDrive\\Java3.0\\tdt4100\\";
		int home = 1;
		if (home == 0) {
			location = "E:\\SkyDrive\\Java3.0\\tdt4100\\";
		}
		try {
			str = rw.readFromFile("level2", location);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(str);

		try {
			rw.writeToFile(str);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
