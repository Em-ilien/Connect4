package fr.em_ilien.connect4;

public class Cell {

	private int row;
	private int column;

	private boolean isPlayed;

	public Cell(int column, int row) {
		this.column = column;
		this.row = row;
		this.isPlayed = false;
	}

	public boolean isPlayed() {
		return isPlayed;
	}

	public void markAsPlayed() {
		this.isPlayed = true;
	}

}
