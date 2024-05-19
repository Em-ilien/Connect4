package fr.em_ilien.connect4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

	public static final int COLUMNS_NUMBER = 7;

	private Map<EventType, List<Executable>> listeners = new HashMap<>();

	private List<Column> columns;
	private Color currentColor;

	public Game() {
		initColumn();
		currentColor = Color.YELLOW;
	}

	public void play(int column) {
		columns.get(column).play(currentColor);

		final StopCondition stopCondition = new StopCondition(this);
		if (stopCondition.isGameFinished())
			notifyListeners(EventType.STOP_GAME);
		else
			currentColor = currentColor.getOther();
	}

	private void notifyListeners(EventType eventType) {
		final List<Executable> listeners = this.listeners.get(eventType);
		if (listeners == null)
			return;

		for (Executable executable : listeners)
			try {
				executable.execute();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
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

	public void addEventListener(EventType stopGame, Executable executable) {
		List<Executable> typeListeners = this.listeners.get(stopGame);
		if (typeListeners == null) {
			typeListeners = new ArrayList<Executable>();
			this.listeners.put(stopGame, typeListeners);
		}
		typeListeners.add(executable);
	}

}
