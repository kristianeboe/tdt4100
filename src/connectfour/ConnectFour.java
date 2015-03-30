package connectfour;

import java.util.ArrayList;

public class ConnectFour {
	
	private ArrayList<ArrayList<Piece>> board;
	private char player;
	private String moves;
	private String undoneMoves;
	
	public ConnectFour() {
		board = new ArrayList<ArrayList<Piece>>();
		for (int r = 0; r < 7; r++) {
			board.add(new ArrayList<Piece>());
			for (int c = 0; c < 7; c++) {
				board.get(r).add(new Piece(' '));
			}
		}
		player = 'o';
		moves = "";
		undoneMoves = "";
	}
	
	public Piece getPiece(int r, int c) {
		return board.get(r).get(c);
	}
	
	public void setPiece(int r, int c, Piece piece) {
		board.get(r).set(c, piece);
	}
	
	public boolean drop(int c) {
		// Check whether a piece can be dropped in column c
		if (getPiece(0, c).getValue() != ' ' ) {
			return false;
		} else {
			// Find row the piece will drop to
			for (int r = 6; r >= 0; r--) {
				if (getPiece(r, c).getValue() == ' ') {
					setPiece(r, c, new Piece(player));
					moves = moves + c;
					undoneMoves = "";
					return true;
				}
			}
			throw new IllegalStateException();
		}
	}
	
	public void undo(){
		if(moves.length() > 0){
			int c = moves.charAt(moves.length()-1) - '0';
			for (int r = 0; r <= 6; r++) {
				if (getPiece(r,c).getValue() != ' ') {
					setPiece(r,c, new Piece(' '));
					break;
				}
			}
			undoneMoves = undoneMoves + c;
			moves = moves.substring(0, moves.length()-1);
			changePlayer();
		}
		
	}
	
	public void redo(){
		if (undoneMoves.length() > 0) {
			int c = undoneMoves.codePointAt(undoneMoves.length()-1) - '0';
			String tempUndoneMoves = undoneMoves;
			drop(c);
			undoneMoves = tempUndoneMoves;
			undoneMoves = undoneMoves.substring(0, undoneMoves.length()-1);
			changePlayer();
		}
	}
	
	public void changePlayer() {
		if (player == 'o') {
			player = 'x';
		} else {
			player = 'o';
		}
	}
	
	public char getPlayer() {
		return player;
	}
	
	// To be completed next exercise lecture
	public boolean hasWon() {
		for (int r = 0; r < 7; r++) {
			for (int c = 0; c < 7; c++) {
				if (getPiece(r, c).getValue() != ' ' && hasWonFromPosition(r,c)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean hasWonFromPosition(int r, int c) {
		for (int dr = -1; dr <= 1; dr++) {
			for (int dc = -1; dc <= 1; dc++) {
				if (dr != 0 || dc != 0) {
					if (hasWonFromPositionInDirection(r, c, dr, dc)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean hasWonFromPositionInDirection(int r, int c, int dr, int dc) {
		char value = getPiece(r, c).getValue();
		int counter = 0;
		while (0 <= r && r < 7 && 0 <= c && c < 7 && getPiece(r, c).getValue() == value) {
			r += dr;
			c += dc;
			counter++;
		}
		return counter >= 4;
	}
	
	public String toString() {
		String str = "";
		for (int r = 0; r < 7; r++) {
			str += "| ";
			for (int c = 0; c < 7; c++) {
				str += board.get(r).get(c).toString() + " ";
			}
			str += "|\n";
		}
		return str;
	}
	
	public static void main(String[] args) {
		ConnectFour cf = new ConnectFour();
		cf.drop(0);
		cf.changePlayer();
		cf.drop(0);
		cf.changePlayer();
		cf.drop(0);
		cf.changePlayer();
		cf.drop(0);
		cf.changePlayer();
		cf.drop(4);
		cf.changePlayer();
		cf.drop(3);
		System.out.println(cf);
	}
}
