package sudoku;

import java.util.Scanner;

public class MiniSudokuProgram {
	
	MiniSudoku minisudoku;
	
	public void init() {
		minisudoku = new MiniSudoku(".....2..38.273.45....6..87.9.8..5367..6...1..4513..9.8.84..3....79.512.62..8.....");
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (! minisudoku.hasWon()) {
			System.out.println(minisudoku);
			System.out.println("Please enter row col and value of next placement: ");
			// Input in format: <row><whitespace><col><whitespace><value>
			//					e.g. 0 1 1 to set (row, col) = (0,1) to the value 1
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			int value = scanner.nextInt();
			minisudoku.changeField(new Field(value, true), r, c);
		}
		scanner.close();
		System.out.println(minisudoku);
		System.out.println("Congrats - you won the game!");
	}
	
	public static void main(String[] args) {
		MiniSudokuProgram msp = new MiniSudokuProgram();
		msp.init();
		msp.run();
	}
}
