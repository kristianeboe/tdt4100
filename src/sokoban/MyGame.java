package sokoban;

import java.io.IOException;
import java.util.Scanner;

public class MyGame implements ConsoleGame {

	Sokoban board;
	Scanner scanner;

	@Override
	public void init() {
		ReadAndWrite readWrite = new ReadAndWrite();
		scanner = new Scanner(System.in);
		// JFileChooser chooser = new JFileChooser();
		// File selectedFile = null;
		// int status = chooser.showOpenDialog(null);
		// if (status == -1) {
		// System.exit(1);
		// }
		// if (status == JFileChooser.APPROVE_OPTION) {
		// selectedFile = chooser.getSelectedFile();
		// }
		System.out.println("Skriv inn filnavn(level1,2,3,4): ");
		String fileName = "";
		fileName = scanner.nextLine();
		String initialBoard = "";
		String location = "C:\\Users\\Kristian\\SkyDrive\\Java3.0\\tdt4100\\";
		int home = 1;
		if (home == 0) {
			location = "E:\\SkyDrive\\Java3.0\\tdt4100\\";
		}
		try {
			initialBoard = readWrite.readFromFile(fileName, location);
		} catch (IOException e) {
			e.printStackTrace();
		}
		board = new Sokoban(initialBoard);
	}

	@Override
	public void run() {
		int result = 10;
		System.out.println(board.toString());
		while (result != 1 || result != 0 || result != -1) {
			System.out.println("please write a command");
			String input = scanner.next();
			result = doLine(input);
			System.out.println(board.toString());
		}
		if (result == 1) {
			System.out.println("Hail to the");
			System.out
					.println("  /\\ /(_)_ __   __ _ \n / //_/ | '_ \\ / _` |\n/ __ \\| | | | | (_| |\n\\/  \\/|_|_| |_|\\__, |\n               |___/ ");
			System.out.println("Du vant!");
			System.exit(1);
		} else if (result == -1)
			System.out.println("losing");
	}

	@Override
	public Integer doLine(String input) {
		switch (input) {
		case "w":
			board.move(input);
			break;

		case "a":
			board.move(input);

			break;
		case "s":
			board.move(input);

			break;
		case "d":
			board.move(input);

			break;
		case "z":
			board.undo();

			break;
		case "y":
			board.redo();

			break;
		case "save":

			break;
		case "load":

			break;

		default:
			break;
		}
		if (board.hasWon()) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		MyGame game = new MyGame();
		game.init();
		game.run();

	}

}
