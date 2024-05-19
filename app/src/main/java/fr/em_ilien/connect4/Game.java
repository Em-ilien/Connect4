package fr.em_ilien.connect4;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private static final int COLUMNS_NUMBER = 7;

	private List<Column> columns;

	public Game() {
		initColumn();
	}

	public void play(int column) {
		columns.get(column).play();
	}

	private void initColumn() {
		columns = new ArrayList<Column>();

		for (int i = 0; i < COLUMNS_NUMBER; i++)
			columns.add(new Column());
	}

	public Token getToken(int column, int row) {
		return columns.get(column).get(row);
	}

	public boolean isTokenPlayed(int column, int row) {
		return getToken(column, row) != null;
	}

}
