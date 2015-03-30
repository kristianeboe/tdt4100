package sokoban;

import java.util.ArrayList;
import java.util.Stack;

public class Sokoban {

	// SokobanReadWrite = new standardSokobanReadWrite();
	private final ArrayList<ArrayList<Cell>> board;
	public static ArrayList<Integer> goals;
	private int playerX;
	private int playerY;
	private static int hight;
	private static int width;
	private final Stack<Action> undo;
	private final Stack<Action> redo;
	private boolean redoValue;

	public Sokoban(String boardString) {
		undo = new Stack<Action>();
		redo = new Stack<Action>();
		goals = new ArrayList<Integer>();
		int n = boardString.length();
		width = boardString.indexOf('n') - 1;
		for (int i = 0; i < n; i++) {
			if (boardString.charAt(i) == 'n') {
				hight += 1;
			}
		}
		hight++;
		System.out.println("hight: " + hight);
		System.out.println("width: " + width);
		board = new ArrayList<ArrayList<Cell>>();
		int index = 0;
		for (int r = 0; r < hight; r++) {
			board.add(new ArrayList<Cell>());
			for (int c = 0; c < width; c++) {
				char ch = boardString.charAt(index);
				if (ch == 'n') {
					c -= 2;
				} else if (ch == '#') {
					board.get(r).add(new Cell(ch, "wall"));
				} else if (ch == '.') {
					board.get(r).add(new Cell(ch, "goal"));
				} else if (ch == '$') {
					board.get(r).add(new Cell(ch, "box"));
				} else if (ch == '@') {
					board.get(r).add(new Cell(ch, "player"));
					playerX = c;
					playerY = r;
				} else if (ch == ' ') {
					board.get(r).add(new Cell(ch, "open"));
				} else if (ch == '*') {
					board.get(r).add(new Cell(ch, "box on goal"));
				} else if (ch == '+') {
					board.get(r).add(new Cell(ch, "player on goal"));
					playerX = c;
					playerY = r;
				}
				if (index == n - 1) {
					break;
				}
				index++;
			}
		}

		for (int r = 0; r < hight; r++) {
			for (int c = 0; c < width; c++) {
				if (board.get(r).get(c).getType().equals("goal")
						|| board.get(r).get(c).getType().equals("box on goal")
						|| board.get(r).get(c).getType()
								.equals("player on goal")) {
					goals.add(r);
					goals.add(c);
				}
			}
		}
	}

	public int getPlayerX() {
		return playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public void updateGoals() {
		for (int i = 0; i < goals.size() - 1; i += 2) {
			if (board.get(goals.get(i)).get(goals.get(i + 1)).getType()
					.equals("open")) {
				board.get(goals.get(i)).get(goals.get(i + 1)).setSign('.');
				board.get(goals.get(i)).get(goals.get(i + 1)).setType("goal");
			} else if (board.get(goals.get(i)).get(goals.get(i + 1)).getType()
					.equals("box")) {
				board.get(goals.get(i)).get(goals.get(i + 1)).setSign('*');
				board.get(goals.get(i)).get(goals.get(i + 1))
						.setType("box on goal");
			} else if (board.get(goals.get(i)).get(goals.get(i + 1)).getType()
					.equals("player")) {
				board.get(goals.get(i)).get(goals.get(i + 1)).setSign('+');
				board.get(goals.get(i)).get(goals.get(i + 1))
						.setType("player on goal");
			}
		}
	}

	public void move(String direction) {
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
		String type2 = "";
		switch (direction) {
		case "w":
			type2 = board.get(playerY - 1).get(playerX).getType();
			y1 = -1;
			y2 = -2;
			break;
		case "a":
			type2 = board.get(playerY).get(playerX - 1).getType();
			x1 = -1;
			x2 = -2;
			break;
		case "d":
			type2 = board.get(playerY).get(playerX + 1).getType();
			x1 = 1;
			x2 = 2;
			break;
		case "s":
			type2 = board.get(playerY + 1).get(playerX).getType();
			y1 = 1;
			y2 = 2;
			break;
		default:
			break;
		}
		if (isValidMove(direction)) {
			if (type2.equals("open")) {
				board.get(playerY).get(playerX).setSign(' ');
				board.get(playerY).get(playerX).setType("open");
				board.get(playerY + y1).get(playerX + x1).setSign('@');
				board.get(playerY + y1).get(playerX + x1).setType("player");
				undo.push(new Action(false, direction));
			} else if (type2.equals("box")
					&& (board.get(playerY + y2).get(playerX + x2).getType()
							.equals("open"))) {
				board.get(playerY).get(playerX).setSign(' ');
				board.get(playerY).get(playerX).setType("open");
				board.get(playerY + y1).get(playerX + x1).setSign('@');
				board.get(playerY + y1).get(playerX + x1).setType("player");
				board.get(playerY + y2).get(playerX + x2).setSign('$');
				board.get(playerY + y2).get(playerX + x2).setType("box");
				undo.push(new Action(true, direction));
			} else if ((type2.equals("box") && board.get(playerY + y2)
					.get(playerX + x2).getType().equals("goal"))) {
				board.get(playerY).get(playerX).setSign(' ');
				board.get(playerY).get(playerX).setType("open");
				board.get(playerY + y1).get(playerX + x1).setSign('@');
				board.get(playerY + y1).get(playerX + x1).setType("player");
				board.get(playerY + y2).get(playerX + x2).setSign('*');
				board.get(playerY + y2).get(playerX + x2)
						.setType("box on goal");
				undo.push(new Action(true, direction));
			} else if (type2.equals("goal")) {
				board.get(playerY).get(playerX).setSign(' ');
				board.get(playerY).get(playerX).setType("open");
				board.get(playerY + y1).get(playerX + x1).setSign('+');
				board.get(playerY + y1).get(playerX + x1)
						.setType("player on goal");
				undo.push(new Action(false, direction));
			} else if (type2.equals("box on goal")) {
				board.get(playerY).get(playerX).setSign(' ');
				board.get(playerY).get(playerX).setType("open");
				board.get(playerY + y1).get(playerX + x1).setSign('+');
				board.get(playerY + y1).get(playerX + x1)
						.setType("player on goal");
				board.get(playerY + y2).get(playerX + x2).setSign('$');
				board.get(playerY + y2).get(playerX + x2).setType("box");
				undo.push(new Action(true, direction));
			}
		}
		for (int r = 0; r < hight; r++) {
			for (int c = 0; c < width; c++) {
				if (board.get(r).get(c).getSign() == '@'
						|| board.get(r).get(c).getSign() == '+') {
					playerX = c;
					playerY = r;
				}
			}
		}
		x1 = 0;
		x2 = 0;
		y1 = 0;
		y2 = 0;
		updateGoals();
		if (redoValue == false) {
			redo.removeAllElements();
		}
	}

	private boolean isValidMove(String direction) {
		String type = "";
		switch (direction) {
		case "w":
			type = board.get(playerY - 1).get(playerX).getType();
			if (type.equals("wall")
					|| (((type.equals("box") || type.equals("box on goal")) && (board
							.get(playerY - 2).get(playerX).getType()
							.equals("wall") || (board.get(playerY - 2)
							.get(playerX).getType().equals("box on goal") || board
							.get(playerY - 2).get(playerX).getType()
							.equals("box")))))) {
				return false;
			}
			System.out.println("valid");
			return true;
		case "d":
			type = board.get(playerY).get(playerX + 1).getType();
			if (type.equals("wall")
					|| (((type.equals("box") || type.equals("box on goal")) && (board
							.get(playerY).get(playerX + 2).getType()
							.equals("wall") || (board.get(playerY)
							.get(playerX + 2).getType().equals("box on goal") || board
							.get(playerY).get(playerX + 2).getType()
							.equals("box")))))) {
				return false;
			} else if (type.equals("goal"))
				System.out.println("valid");
			return true;
		case "a":
			type = board.get(playerY).get(playerX - 1).getType();
			if (type.equals("wall")
					|| (((type.equals("box") || type.equals("box on goal")) && (board
							.get(playerY).get(playerX - 2).getType()
							.equals("wall") || (board.get(playerY)
							.get(playerX - 2).getType().equals("box on goal") || board
							.get(playerY).get(playerX - 2).getType()
							.equals("box")))))) {
				return false;
			}
			System.out.println("valid");
			return true;
		case "s":
			type = board.get(playerY + 1).get(playerX).getType();
			if (type.equals("wall")
					|| (((type.equals("box") || type.equals("box on goal")) && (board
							.get(playerY + 2).get(playerX).getType()
							.equals("wall") || (board.get(playerY + 2)
							.get(playerX).getType().equals("box on goal") || board
							.get(playerY + 2).get(playerX).getType()
							.equals("box")))))) {
				return false;
			}
			return true;
		default:
			System.out.println("Ugyldig input test!");
			return false;
		}
	}

	public boolean hasWon() {
		for (int i = 0; i < goals.size() - 1; i += 2) {
			if (!board.get(goals.get(i)).get(goals.get(i + 1)).getType()
					.equals("box on goal")) {
				return false;
			}
		}
		return true;
	}

	public void undo() {
		redo.push(undo.peek());
		Action action = undo.pop();
		int x1 = 0, y1 = 0;
		switch (action.getDirection()) {
		case "w":
			y1 = 1;
			break;
		case "a":
			x1 = 1;
			break;
		case "d":
			x1 = -1;
			break;
		case "s":
			y1 = -1;
			break;

		default:
			break;
		}

		board.get(playerY).get(playerX).setSign(' ');
		board.get(playerY).get(playerX).setType("open");
		board.get(playerY + y1).get(playerX + x1).setSign('@');
		board.get(playerY + y1).get(playerX + x1).setType("player");
		if (action.isStonePush()) {
			board.get(playerY).get(playerX).setSign('$');
			board.get(playerY).get(playerX).setType("box");
			board.get(playerY - y1).get(playerX - x1).setSign(' ');
			board.get(playerY - y1).get(playerX - x1).setType("open");
		}
		for (int r = 0; r < hight; r++) {
			for (int c = 0; c < width; c++) {
				if (board.get(r).get(c).getSign() == '@'
						|| board.get(r).get(c).getSign() == '+') {
					playerX = c;
					playerY = r;
				}
			}
		}
	}

	public void redo() {
		redoValue = true;
		Action action = redo.pop();
		move(action.direction);
		redoValue = false;
	}

	@Override
	public String toString() {
		String str = "";
		for (int r = 0; r < hight; r++) {
			for (int c = 0; c < width; c++) {
				str = str + (board.get(r).get(c).toString()) + "     ";
			}
			str = str + "\n\n";
		}
		return str;
	}
}
