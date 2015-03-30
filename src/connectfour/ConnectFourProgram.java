package connectfour;

import java.util.Scanner;

public class ConnectFourProgram {
	
	ConnectFour connectFour;
	
	public void init() {
		connectFour = new ConnectFour();
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (! connectFour.hasWon()) {
			System.out.println(connectFour);
			System.out.println("Player " + connectFour.getPlayer() + ", enter column of next drop:");
			int c = scanner.nextInt();
			if (c == -1) {
				connectFour.undo();
			} else if (c == -2) {
				connectFour.redo();
			} else {
				if (connectFour.drop(c)) {
					connectFour.changePlayer();
				}				
			}
		}
		System.out.println(connectFour);
		connectFour.changePlayer();
		System.out.println("Congratulations player " + connectFour.getPlayer() + "! You have won the game.");
	}
	
	public static void main(String[] args) {
		ConnectFourProgram cfp = new ConnectFourProgram();
		cfp.init();
		cfp.run();
	}
}
