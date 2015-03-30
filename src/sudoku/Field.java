package sudoku;

public class Field {
	
	private int value;
	private boolean changable;
	
	// Note well that validation should have been included in this
	// class (e.g. making sure Field objects are not given negative values).
	// This was omitted in the exercise lecture.
	
	public Field(int value, boolean changable) {
		this.value = value;
		this.changable = changable;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		if (changable) {
			this.value = value;
		}
	}
	
	public boolean isChangable() {
		return changable;
	}
	
	public String toString() {
		return value == 0 ? " " : value + "";
	}
}
