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
		final Color color = checkIfWinnerOnHorinzontalLines();
		if (color != null)
			return color;
		return null;
	}

	private Color checkIfWinnerOnHorinzontalLines() {
		for (int i = 0; i < Grid.COLUMNS_NUMBER; i++) {
			if (this.grid.getColumn(MIDDLE_COLUMN).getTokenAtRow(i) == null)
				continue;
			final Color color = this.grid.getColumn(MIDDLE_COLUMN).getTokenAtRow(i).getColor();

			final List<Integer> coloredCell = new ArrayList<>();
			coloredCell.add(MIDDLE_COLUMN);
			coloredCell.addAll(fetchTokenWithSameColorInRow(i, color, true));
			coloredCell.addAll(fetchTokenWithSameColorInRow(i, color, false));

			if (coloredCell.size() >= REQUIRED_ALIGNED_TOKENS_TO_WIN)
				return color;
		}
		return null;
	}

	private List<Integer> fetchTokenWithSameColorInRow(int row, final Color color, boolean checkLeftColumns) {
		final List<Integer> coloredCell = new ArrayList<>();
		int column = MIDDLE_COLUMN;
		do {
			if (checkLeftColumns)
				column--;
			else
				column++;
			final Token token = this.grid.getColumn(column).getTokenAtRow(row);
			if (token == null || token.getColor() != color)
				break;
			coloredCell.add(column);
		} while (Math.abs(MIDDLE_COLUMN - column) < REQUIRED_ALIGNED_TOKENS_TO_WIN - 1);
		return coloredCell;
	}
}
