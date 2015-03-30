package sokoban;

public class Cell {

	private char sign;
	private String type;

	public Cell(char sign, String type) {
		this.sign = sign;
		this.type = type;
	}

	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return sign + "";
	}

}
