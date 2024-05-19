package fr.em_ilien.connect4;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	public static final int COLUMNS_NUMBER = 7;
	public static final int ROWS_NUMBER = 6;

	private List<Column> columns;
	private Game game;

	public Grid(Game game) {
		this.game = game;
		initColumns();
	}

	private void initColumns() {
		columns = new ArrayList<Column>();
		for (int i = 0; i < COLUMNS_NUMBER; i++)
			columns.add(new Column(game));
	}

	public Column getColumn(int column) {
		if (column >= columns.size())
			throw new IndexOutOfBoundsException();

		return columns.get(column);
	}
}
