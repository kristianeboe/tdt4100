package interfaces;

import java.util.ArrayList;

public class StringGridImpl implements StringGrid {

	private int rows;
	private int columns;
	public ArrayList<ArrayList<String>> grid;

	public StringGridImpl(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		int index = 0;
		String gridList = "abcdefghijklmnopqrstvwxyz";
		grid = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < 4; i++) {
			grid.add(new ArrayList<String>());
			for (int j = 0; j < 4; j++) {
				grid.get(i).add(Character.toString(gridList.charAt(index++)));

			}
		}
	}

	@Override
	public int getRowCount() {
		return rows;
	}

	@Override
	public int getColumnCount() {
		return columns;
	}

	@Override
	public String getElement(int row, int column) {
		return grid.get(row).get(column);
	}

	@Override
	public void setElement(int row, int column, String element) {
		grid.get(row).set(column, element);
	}

}
