package fr.em_ilien.connect4;

import java.util.ArrayList;
import java.util.List;

public class Column {
	private static final int ROW_NUMBERS = 6;
	private List<Token> tokens;

	public Column() {
		tokens = new ArrayList<Token>();
	}

	public void play() {
		if (tokens.size() + 1 > ROW_NUMBERS)
			return;
		tokens.add(new Token());
	}

	public Token get(int row) {
		if (row >= tokens.size())
			return null;
		return tokens.get(row);
	}

}
