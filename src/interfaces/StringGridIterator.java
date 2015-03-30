package interfaces;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {

	private int index;
	private boolean rowMajor;
	private StringGrid grid;
	private int row;
	private int column;
	private int index2 = 0;

	public StringGridIterator(StringGrid grid, boolean rowMajor) {
		this.rowMajor = rowMajor;
		this.grid = grid;
		this.row = 0;
		this.column = 0;
	}

	@Override
	public boolean hasNext() {
		return index2++ < grid.getRowCount() * grid.getColumnCount();
	}

	@Override
	public String next() {
		try {
			if (rowMajor == true) {
				if (column != grid.getColumnCount()) {
					return grid.getElement(row, column++);
				} else {
					column = 0;
					row++;
					index++;
					return grid.getElement(row, column++);
				}
			} else {
				if (row != grid.getRowCount()) {
					return grid.getElement(row++, column);
				} else {
					row = 0;
					column++;
					index++;
					return grid.getElement(row++, column);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println();
		}
		return "S";
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();

	}

}
