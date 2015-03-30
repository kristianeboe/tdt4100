package interfaces;

public class StringGridPorgram {
	private StringGridIterator it;
	private StringGridImpl stringGrid;
	private int index;

	public void init() {
		stringGrid = new StringGridImpl(4, 4);
		it = new StringGridIterator(stringGrid, false);
	}

	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println(stringGrid.grid.get(i));
		}
		index = 0;
		while (it.hasNext()) {
			System.out.print(it.next());
			index++;
			if (index % 4 == 0) {
				System.out.print("\n");
			}

		}

	}

	public static void main(String[] args) {
		StringGridPorgram gp = new StringGridPorgram();
		gp.init();
		gp.run();
	}
}
