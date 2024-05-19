package fr.em_ilien.connect4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
	private Map<EventType, List<Executable>> listeners = new HashMap<>();

	public void addEventListener(Game game, EventType stopGame, Executable executable) {
		List<Executable> typeListeners = this.listeners.get(stopGame);
		if (typeListeners == null) {
			typeListeners = new ArrayList<Executable>();
			this.listeners.put(stopGame, typeListeners);
		}
		typeListeners.add(executable);
	}

	protected void notifyListeners(Game game, EventType eventType) {
		final List<Executable> listeners = this.listeners.get(eventType);
		if (listeners == null)
			return;

		for (Executable executable : listeners)
			executable.execute();
	}
}
