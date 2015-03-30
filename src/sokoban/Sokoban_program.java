package sokoban;

import java.io.IOException;
import java.util.Scanner;

public class Sokoban_program {
	private Sokoban board;

	public void init() {
		board = new Sokoban(
				"*###########*\\n#           #\\n#  ... ...  #\\n#  *$$ $.$  #\\n# $*+$ $*$$ #\\n#  *$$ $.$  #\\n#  ...  .   #\\n#           #\\n*###########*");
	}

	public void run() throws IOException {
		System.out.println("Welcome to");
		System.out
				.println(" __       _         _                 \n/ _\\ ___ | | _____ | |__   __ _ _ __  \n\\ \\ / _ \\| |/ / _ \\| '_ \\ / _` | '_ \\ \n_\\ \\ (_) |   < (_) | |_) | (_| | | | |\n\\__/\\___/|_|\\_\\___/|_.__/ \\__,_|_| |_|\n\n\n\n\n");
		System.out.println(board.toString());
		Scanner scanner = new Scanner(System.in);
		while (!board.hasWon()) {
			String direction = scanner.next();
			if (direction.equalsIgnoreCase("z")) {
				board.undo();
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				board.updateGoals();
				System.out.println(board.toString());
				continue;
			} else if (direction.equalsIgnoreCase("y")) {
				board.redo();
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				board.updateGoals();
				System.out.println(board.toString());
				continue;
			}
			board.move(direction);
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			board.updateGoals();
			System.out.println(board.toString());
			// board.writeToFile();
		}
		scanner.close();

	}

	public static void main(String[] args) throws IOException {
		Sokoban_program soko = new Sokoban_program();
		soko.init();
		soko.run();
	}

}
