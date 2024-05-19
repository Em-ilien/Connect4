package fr.em_ilien.connect4;

import java.util.ArrayList;
import java.util.List;

public class Column {
	private static final int ROW_NUMBERS = 6;

	private List<Token> tokens;
	private Game game;

	public Column(Game game) {
		this.game = game;
		tokens = new ArrayList<Token>();
	}

	public void play() {
		if (!canPlay())
			throw new IllegalStateException();
		tokens.add(new Token(game.getCurrentColor()));
		game.updateStatus();
	}

	private boolean canPlay() {
		return tokens.size() + 1 <= ROW_NUMBERS;
	}

	public Token getTokenAtRow(int row) {
		if (row >= tokens.size())
			return null;
		return tokens.get(row);
	}

	public boolean isTokenPlayed(int row) {
		return getTokenAtRow(row) != null;
	}

}
