package fr.em_ilien.connect4;

import java.util.ArrayList;
import java.util.List;

public class Column {
	private static final int ROW_NUMBERS = 6;
	private List<Token> tokens;

	public Column() {
		tokens = new ArrayList<Token>();
	}

	public void play(Color color) {
		if (tokens.size() + 1 > ROW_NUMBERS)
			throw new IllegalStateException();
		tokens.add(new Token(color));
	}

	public Token get(int row) {
		if (row >= tokens.size())
			return null;
		return tokens.get(row);
	}

}
