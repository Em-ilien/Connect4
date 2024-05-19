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
		game.addEventListener(EventType.STOP_GAME, () -> {
			isFinished.set(true);
		});

		game.play(0);
		game.play(0);
		game.play(1);
		game.play(1);
		game.play(2);
		game.play(2);

		assertThat(isFinished.get()).isFalse();
		game.play(3);
		assertThat(isFinished.get()).isTrue();
	}

}
