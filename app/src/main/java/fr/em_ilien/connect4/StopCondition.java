package fr.em_ilien.connect4;

import java.util.ArrayList;
import java.util.List;

public class StopCondition {
	private static final int REQUIRED_ALIGNED_TOKENS_TO_WIN = 4;
	private static final int MIDDLE_COLUMN = 4 - 1;

	private Grid grid;

	public StopCondition(Game game) {
		this.grid = game.getGrid();
	}

	public Color getWinner() {
		for (int i = 0; i < Grid.COLUMNS_NUMBER; i++) {
			if (this.grid.getColumn(MIDDLE_COLUMN).getTokenAtRow(i) == null)
				continue;
			final Color color = this.grid.getColumn(MIDDLE_COLUMN).getTokenAtRow(i).getColor();
			final List<Integer> coloredCell = new ArrayList<>();
			coloredCell.add(MIDDLE_COLUMN);
			int j = MIDDLE_COLUMN;
			do {
				j--;
				if (this.grid.getColumn(j).getTokenAtRow(i) == null || this.grid.getColumn(j).getTokenAtRow(i).getColor() != color)
					break;
				coloredCell.add(j);
			} while (Math.abs(MIDDLE_COLUMN - j) < REQUIRED_ALIGNED_TOKENS_TO_WIN - 1);
			j = MIDDLE_COLUMN;
			do {
				j++;
				if (this.grid.getColumn(j).getTokenAtRow(i) == null || this.grid.getColumn(j).getTokenAtRow(i).getColor() != color)
					break;
				coloredCell.add(j);
			} while (Math.abs(MIDDLE_COLUMN - j) < REQUIRED_ALIGNED_TOKENS_TO_WIN - 1);

			if (coloredCell.size() >= REQUIRED_ALIGNED_TOKENS_TO_WIN)
				return color;
		}
		return null;
	}
}
