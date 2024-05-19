package fr.em_ilien.connect4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StopConditionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	class HorizontallyStopConditionTest {
		@Test
		void stopConditionRow() {
			AtomicBoolean isFinished = new AtomicBoolean(false);

			Game game = new Game();
			game.getEventManager().addEventListener(game, EventType.STOP_GAME, () -> {
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

		@Test
		void stopConditionRowRight() {
			AtomicBoolean isFinished = new AtomicBoolean(false);

			Game game = new Game();
			game.getEventManager().addEventListener(game, EventType.STOP_GAME, () -> {
				isFinished.set(true);
			});

			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(4).play();
			game.getGrid().getColumn(4).play();
			game.getGrid().getColumn(5).play();
			game.getGrid().getColumn(5).play();

			assertThat(isFinished.get()).isFalse();
			game.getGrid().getColumn(6).play();
			assertThat(isFinished.get()).isTrue();
		}

		@Test
		void stopConditionMiddle() {
			AtomicBoolean isFinished = new AtomicBoolean(false);

			Game game = new Game();
			game.getEventManager().addEventListener(game, EventType.STOP_GAME, () -> {
				isFinished.set(true);
			});

			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(4).play();
			game.getGrid().getColumn(4).play();

			assertThat(isFinished.get()).isFalse();
			game.getGrid().getColumn(5).play();
			assertThat(isFinished.get()).isTrue();
		}

		@Test
		void stopConditionRow2() {
			AtomicBoolean isFinished = new AtomicBoolean(false);

			Game game = new Game();
			game.getEventManager().addEventListener(game, EventType.STOP_GAME, () -> {
				isFinished.set(true);
			});

			game.getGrid().getColumn(1).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(4).play();
			game.getGrid().getColumn(5).play();
			game.getGrid().getColumn(6).play();

			game.getGrid().getColumn(1).play();
			game.getGrid().getColumn(6).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(6).play();
			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(1).play();

			assertThat(isFinished.get()).isFalse();
			game.getGrid().getColumn(4).play();
			assertThat(isFinished.get()).isTrue();
		}
	}

	@Nested
	class VerticallyStopConditionTest {

		@Test
		void stopConditionVertically() {
			AtomicBoolean isFinished = new AtomicBoolean(false);

			Game game = new Game();
			game.getEventManager().addEventListener(game, EventType.STOP_GAME, () -> {
				isFinished.set(true);
			});

			game.getGrid().getColumn(1).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(1).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(1).play();
			game.getGrid().getColumn(2).play();

			assertThat(isFinished.get()).isFalse();
			game.getGrid().getColumn(1).play();
			assertThat(isFinished.get()).isTrue();
		}

		@Test
		void stopConditionVerticallyRight() {
			AtomicBoolean isFinished = new AtomicBoolean(false);

			Game game = new Game();
			game.getEventManager().addEventListener(game, EventType.STOP_GAME, () -> {
				isFinished.set(true);
			});

			game.getGrid().getColumn(6).play();
			game.getGrid().getColumn(1).play();
			game.getGrid().getColumn(6).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(6).play();
			game.getGrid().getColumn(3).play();

			assertThat(isFinished.get()).isFalse();
			game.getGrid().getColumn(6).play();
			assertThat(isFinished.get()).isTrue();
		}
	}

	@Nested
	class DiagonallyStopConditionTest {

		@Test
		void stopConditionDiagonallyToBottomRight() {
			AtomicBoolean isFinished = new AtomicBoolean(false);

			Game game = new Game();
			game.getEventManager().addEventListener(game, EventType.STOP_GAME, () -> {
				isFinished.set(true);
			});

			game.getGrid().getColumn(6).play();
			game.getGrid().getColumn(5).play();
			game.getGrid().getColumn(5).play();
			game.getGrid().getColumn(4).play();
			game.getGrid().getColumn(4).play();
			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(4).play();
			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(4).play();

			assertThat(isFinished.get()).isFalse();
			game.getGrid().getColumn(3).play();
			assertThat(isFinished.get()).isTrue();
		}

		@Test
		void stopConditionDiagonallyToBottomRight2() {
			AtomicBoolean isFinished = new AtomicBoolean(false);

			Game game = new Game();
			game.getEventManager().addEventListener(game, EventType.STOP_GAME, () -> {
				isFinished.set(true);
			});

			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(1).play();
			game.getGrid().getColumn(1).play();
			game.getGrid().getColumn(0).play();
			game.getGrid().getColumn(1).play();
			game.getGrid().getColumn(0).play();
			game.getGrid().getColumn(0).play();
			game.getGrid().getColumn(1).play();

			assertThat(isFinished.get()).isFalse();
			game.getGrid().getColumn(0).play();
			assertThat(isFinished.get()).isTrue();
		}

		@Test
		void stopConditionDiagonallyToBottomRight3() {
			AtomicBoolean isFinished = new AtomicBoolean(false);

			Game game = new Game();
			game.getEventManager().addEventListener(game, EventType.STOP_GAME, () -> {
				isFinished.set(true);
			});

			game.getGrid().getColumn(5).play();
			game.getGrid().getColumn(4).play();
			game.getGrid().getColumn(4).play();
			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(3).play();

			assertThat(isFinished.get()).isFalse();
			game.getGrid().getColumn(2).play();
			assertThat(isFinished.get()).isTrue();
		}

		@Test
		void stopConditionDiagonallyToBottomRight4() {
			AtomicBoolean isFinished = new AtomicBoolean(false);

			Game game = new Game();
			game.getEventManager().addEventListener(game, EventType.STOP_GAME, () -> {
				isFinished.set(true);
			});

			game.getGrid().getColumn(4).play();
			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(1).play();
			game.getGrid().getColumn(2).play();
			game.getGrid().getColumn(1).play();
			game.getGrid().getColumn(1).play();
			game.getGrid().getColumn(2).play();

			assertThat(isFinished.get()).isFalse();
			game.getGrid().getColumn(1).play();
			assertThat(isFinished.get()).isTrue();
		}

		@Test
		void stopConditionDiagonallyToTopLeft() {
			AtomicBoolean isFinished = new AtomicBoolean(false);

			Game game = new Game();
			game.getEventManager().addEventListener(game, EventType.STOP_GAME, () -> {
				isFinished.set(true);
			});

			game.getGrid().getColumn(3).play();
			game.getGrid().getColumn(4).play();
			game.getGrid().getColumn(4).play();
			game.getGrid().getColumn(5).play();
			game.getGrid().getColumn(5).play();
			game.getGrid().getColumn(6).play();
			game.getGrid().getColumn(5).play();
			game.getGrid().getColumn(6).play();
			game.getGrid().getColumn(6).play();
			game.getGrid().getColumn(5).play();

			assertThat(isFinished.get()).isFalse();
			game.getGrid().getColumn(6).play();
			assertThat(isFinished.get()).isTrue();
		}

	}

}
