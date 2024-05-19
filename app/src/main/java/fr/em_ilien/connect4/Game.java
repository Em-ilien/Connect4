package fr.em_ilien.connect4;

public class Game {
	private Grid grid;
	private Color currentColor;
	public EventManager eventManager;

	public Game() {
		grid = new Grid(this);
		currentColor = Color.YELLOW;
		eventManager = new EventManager();
	}

	public Color getCurrentColor() {
		return currentColor;
	}

	public Color getWinner() {
		final StopCondition stopCondition = new StopCondition(this);
		return stopCondition.getWinner();
	}

	public Grid getGrid() {
		return this.grid;
	}

	protected void updateStatus() {
		if (isGameFinished())
			eventManager.notifyListeners(this, EventType.STOP_GAME);
		else
			changeCurrentColor();
	}

	private void changeCurrentColor() {
		currentColor = currentColor.getOther();
	}

	private boolean isGameFinished() {
		return getWinner() != null;
	}
}
