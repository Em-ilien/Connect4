package fr.em_ilien.connect4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventManagerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void stopGameButNoListeners() {
		Game game = new Game();
		game.getGrid().getColumn(0).play();
		game.getGrid().getColumn(0).play();
		game.getGrid().getColumn(1).play();
		game.getGrid().getColumn(1).play();
		game.getGrid().getColumn(2).play();
		game.getGrid().getColumn(2).play();

		game.getGrid().getColumn(3).play();
	}
	
	@Test
	void stopGameWithTwoListeners() {
		Game game = new Game();
		game.getEventManager().addEventListener(game, EventType.STOP_GAME, () -> {});
		game.getEventManager().addEventListener(game, EventType.STOP_GAME, () -> {});
		game.getGrid().getColumn(0).play();
		game.getGrid().getColumn(0).play();
		game.getGrid().getColumn(1).play();
		game.getGrid().getColumn(1).play();
		game.getGrid().getColumn(2).play();
		game.getGrid().getColumn(2).play();

		game.getGrid().getColumn(3).play();
	}
}
