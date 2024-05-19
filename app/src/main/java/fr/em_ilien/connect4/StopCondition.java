package fr.em_ilien.connect4;

import java.util.ArrayList;
import java.util.List;

public class StopCondition {
	private static final int REQUIRED_ALIGNED_TOKENS_TO_WIN = 4;
	private static final int MIDDLE_COLUMN = 4 - 1;
	private static final int MIDDLE_ROW = 4 - 1;

	private Grid grid;

	public StopCondition(Game game) {
		this.grid = game.getGrid();
	}

	public Color getWinner() {
		Color color = null;

		color = checkIfWinnerOnHorinzontalLines();
		if (color != null)
			return color;

		color = checkIfWinnerOnVerticalLines();
		if (color != null)
			return color;

		color = checkIfWinnerOnDiagonalLeftToRight();
		if (color != null)
			return color;

		color = checkIfWinnerOnDiagonalRightToLeft();
		if (color != null)
			return color;
		return null;
	}

	private Color checkIfWinnerOnHorinzontalLines() {
		for (int i = 0; i < Grid.ROWS_NUMBER; i++) {
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

	private Color checkIfWinnerOnVerticalLines() {
		for (int i = 0; i < Grid.COLUMNS_NUMBER; i++) {
			if (this.grid.getColumn(i).getTokenAtRow(MIDDLE_ROW) == null)
				continue;
			final Color color = this.grid.getColumn(i).getTokenAtRow(MIDDLE_ROW).getColor();

			final List<Integer> coloredCell = new ArrayList<>();
			coloredCell.add(MIDDLE_ROW);
			coloredCell.addAll(fetchTokenWithSameColorInColumn(i, color, true));
			coloredCell.addAll(fetchTokenWithSameColorInColumn(i, color, false));

			if (coloredCell.size() >= REQUIRED_ALIGNED_TOKENS_TO_WIN)
				return color;
		}
		return null;
	}

	private List<Integer> fetchTokenWithSameColorInColumn(int column, final Color color, boolean checkBottomRows) {
		final List<Integer> coloredCell = new ArrayList<>();
		int row = MIDDLE_ROW;
		do {
			if (checkBottomRows)
				row--;
			else
				row++;
			final Token token = this.grid.getColumn(column).getTokenAtRow(row);
			if (token == null || token.getColor() != color)
				break;
			coloredCell.add(row);
		} while (Math.abs(MIDDLE_COLUMN - row) < REQUIRED_ALIGNED_TOKENS_TO_WIN - 1);
		return coloredCell;
	}

	private Color checkIfWinnerOnDiagonalLeftToRight() {
		for (int i = 0; i < Grid.ROWS_NUMBER; i++) {
			for (int j = 0; j < Grid.COLUMNS_NUMBER; j++) {
				if (this.grid.getColumn(j).getTokenAtRow(i) == null)
					continue;
				final Color color = this.grid.getColumn(j).getTokenAtRow(i).getColor();

				if (checkDiagonalLeftToRight(i, j, color, 1) >= REQUIRED_ALIGNED_TOKENS_TO_WIN)
					return color;
			}
		}
		return null;
	}

	private Color checkIfWinnerOnDiagonalRightToLeft() {
		for (int i = 0; i < Grid.ROWS_NUMBER; i++) {
			for (int j = 0; j < Grid.COLUMNS_NUMBER; j++) {
				if (this.grid.getColumn(j).getTokenAtRow(i) == null)
					continue;
				final Color color = this.grid.getColumn(j).getTokenAtRow(i).getColor();

				if (checkDiagonalRightToLeft(i, j, color, 1) >= REQUIRED_ALIGNED_TOKENS_TO_WIN)
					return color;
			}
		}
		return null;
	}

	private int checkDiagonalLeftToRight(int row, int column, final Color color, int count) {
		if (row >= Grid.ROWS_NUMBER - 1 || column >= Grid.COLUMNS_NUMBER - 1)
			return count;

		final Token token = this.grid.getColumn(column + 1).getTokenAtRow(row + 1);
		if (token == null || token.getColor() != color)
			return count;

		return checkDiagonalLeftToRight(row + 1, column + 1, color, count + 1);
	}

	private int checkDiagonalRightToLeft(int row, int column, final Color color, int count) {
		if (row >= Grid.ROWS_NUMBER - 1 || column <= 0)
			return count;

		final Token token = this.grid.getColumn(column - 1).getTokenAtRow(row + 1);
		if (token == null || token.getColor() != color)
			return count;

		return checkDiagonalRightToLeft(row + 1, column - 1, color, count + 1);
	}

}
