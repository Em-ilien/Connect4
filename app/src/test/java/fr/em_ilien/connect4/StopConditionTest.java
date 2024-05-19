package fr.em_ilien.connect4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StopConditionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void stopConditionRow() {
		AtomicBoolean isFinished = new AtomicBoolean(false);

		Game game = new Game();
		game.eventManager.addEventListener(game, EventType.STOP_GAME, () -> {
			isFinished.set(true);
		});

		game.getGrid().getColumn(0).play();
		game.getGrid().getColumn(0).play();
		game.getGrid().getColumn(1).play();
		game.getGrid().getColumn(1).play();
		game.getGrid().getColumn(2).play();
		game.getGrid().getColumn(2).play();

		assertThat(isFinished.get()).isFalse();
		game.getGrid().getColumn(3).play();
		assertThat(isFinished.get()).isTrue();
	}

}
