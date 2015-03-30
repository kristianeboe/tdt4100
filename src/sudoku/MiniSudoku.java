package sudoku;

import java.util.ArrayList;

public class MiniSudoku {
	
	ArrayList<ArrayList<Field>> board;
	
	public MiniSudoku(String boardString) {
		board = new ArrayList<ArrayList<Field>>();
		int index = 0;
		for (int r = 0; r < 9; r++) {
			board.add(new ArrayList<Field>());
			for (int c = 0; c < 9; c++) {
				char ch = boardString.charAt(index);
				if (Character.isDigit(ch)) {
					// ch - '0' converts from char representation of number to int representation of same number
					board.get(r).add(new Field(ch - '0', false));
				} else {
					// ' ' in boardString are empty fields
					board.get(r).add(new Field(0, true));
				}
				index++;
			}
		}
	}
	
	// Internal encapsulation - getter
	private Field getField(int r, int c) {
		return board.get(r).get(c);
	}
	
	// Internal encapsulation - setter
	private void setField(Field field, int r, int c) {
		board.get(r).set(c, field);
	}
	
	public boolean changeField(Field field, int r, int c) {
		// Should not alter Fields that cannot be changed 
		if (! getField(r,c).isChangable()) {
			return false;
		}
		// Should be allowed to "erase" a field i.e. set its value to 0
		if (field.getValue() == 0) {
			setField(field, r, c);
			return true;
		}
		// Check for conflicts (row, col or box)
		if (checkRow(field, r) && checkCol(field, c)/* && checkBox(field, r, c)*/) {
			setField(field, r, c);
			return true;
		}
		return false;
	}
	
	// Check whether Field value already is present in the same row
	private boolean checkRow(Field field, int r) {
		int value = field.getValue();
		for (int c = 0; c < 9; c++) {
			if (getField(r, c).getValue() == value) {
				return false;
			}
		}
		return true;
	}

	// Check whether Field value already is present in the same col
	private boolean checkCol(Field field, int c) {
		int value = field.getValue();
		for (int r = 0; r < 9; r++) {
			if (getField(r, c).getValue() == value) {
				return false;
			}
		}
		return true;
	}
	
	// Check whether Field value already is present in the relevant box
	/*private boolean checkBox(Field field, int r, int c) {
		int value = field.getValue();
		int r1 = (r / 2) * 2;
		int r2 = r1 + 1;
		int c1 = (c / 2) * 2;
		int c2 = c1 + 1;
		if (getField(r1, c1).getValue() == value || getField(r1, c2).getValue() == value ||
				getField(r2, c1).getValue() == value || getField(r2, c2).getValue() == value) {
			return false;
		}
		return true;
	}*/
	
	// Check whether any fields are "empty" i.e. value == 0
	public boolean hasWon() {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (getField(r, c).getValue() == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	// One should strive for nicer toString() output than this,  
	// however, this was not the emphasis of the exercise lecture
	public String toString() {
		String str = "";
		for (int r = 0; r < 9; r++) {
			str += board.get(r).toString() + "\n";
		}
		return str;
	}
	
	public static void main(String[] args) {
		MiniSudoku ms = new MiniSudoku("3  2 41  32 4  1");
		System.out.println(ms);
	}
}
