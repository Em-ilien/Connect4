package fr.em_ilien.connect4;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private static final int COLUMNS_NUMBER = 7;
	private static final int ROW_NUMBERS = 6;

	private List<List<Cell>> cells;

	public Game() {
		initCells();
	}

	public void play(int column) {
		cells.get(column).get(0).markAsPlayed();
	}

	private void initCells() {
		cells = new ArrayList<List<Cell>>();

		for (int i = 0; i < COLUMNS_NUMBER; i++) {
			final ArrayList<Cell> row = new ArrayList<Cell>();
			for (int j = 0; j < ROW_NUMBERS; j++)
				row.add(new Cell(i, j));
			cells.add(row);
		}
	}

	public Cell getCell(int column, int row) {
		return cells.get(column).get(row);
	}

}
