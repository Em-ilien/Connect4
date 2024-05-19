package fr.em_ilien.connect4;

import java.util.ArrayList;
import java.util.List;

public class StopCondition {
	private static final int REQUIRED_ALIGNED_TOKENS_TO_WIN = 4;
	private static final int MIDDLE_COLUMN = 4 - 1;

	private Game game;

	public StopCondition(Game game) {
		this.game=game;
	}

	public boolean isGameFinished() {
		for (int i = 0; i < Game.COLUMNS_NUMBER; i++) {
			if (game.getToken(MIDDLE_COLUMN, i) == null)
				continue;
			final Color color = game.getToken(MIDDLE_COLUMN, i).getColor();
			final List<Integer> coloredCell = new ArrayList<>();
			coloredCell.add(MIDDLE_COLUMN);
			int j = MIDDLE_COLUMN;
			do {
				j--;
				if (game.getToken(j, i) == null || game.getToken(j, i).getColor() != color)
					break;
				coloredCell.add(j);
			} while (Math.abs(MIDDLE_COLUMN - j) < REQUIRED_ALIGNED_TOKENS_TO_WIN - 1);
			j = MIDDLE_COLUMN;
			do {
				j++;
				if (game.getToken(j, i) == null || game.getToken(j, i).getColor() != color)
					break;
				coloredCell.add(j);
			} while (Math.abs(MIDDLE_COLUMN - j) < REQUIRED_ALIGNED_TOKENS_TO_WIN - 1);

			if (coloredCell.size() >= REQUIRED_ALIGNED_TOKENS_TO_WIN)
				return true;
		}
		return false;
	}
}
