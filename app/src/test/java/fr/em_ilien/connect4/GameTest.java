package fr.em_ilien.connect4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void createANewGame() {
		Game game = new Game();
		assertThat(game).isInstanceOf(Game.class);
	}

	@Test
	void placeAToken() {
		Game game = new Game();
		game.getGrid().getColumn(3).play();
		assertThat(game.getGrid().isTokenPlayed(3, 0)).isTrue();
		assertThat(game.getGrid().isTokenPlayed(3, 1)).isFalse();
		assertThat(game.getGrid().isTokenPlayed(0, 0)).isFalse();
	}

	@Test
	void placeTwoTokens() {
		Game game = new Game();
		game.getGrid().getColumn(3).play();
		game.getGrid().getColumn(3).play();
		assertThat(game.getGrid().isTokenPlayed(3, 0)).isTrue();
		assertThat(game.getGrid().isTokenPlayed(3, 1)).isTrue();
	}

	@Test
	void placeSevenTokens() {
		Game game = new Game();
		game.getGrid().getColumn(3).play();
		game.getGrid().getColumn(3).play();
		game.getGrid().getColumn(3).play();
		game.getGrid().getColumn(3).play();
		game.getGrid().getColumn(3).play();
		game.getGrid().getColumn(3).play();
		assertThrowsExactly(IllegalStateException.class, () -> game.getGrid().getColumn(3).play());
	}

	@Test
	void placeTokenInInexistingColumns() {
		Game game = new Game();
		assertThrowsExactly(IndexOutOfBoundsException.class, () -> game.getGrid().getColumn(-1).play());
		assertThrowsExactly(IndexOutOfBoundsException.class, () -> game.getGrid().getColumn(7).play());
	}

	@Test
	void alternateColors() {
		Game game = new Game();
		game.getGrid().getColumn(0).play();
		assertThat(game.getGrid().getColumn(0).getTokenAtRow(0).isYellow()).isTrue();
		assertThat(game.getGrid().getColumn(0).getTokenAtRow(0).isRed()).isFalse();

		game.getGrid().getColumn(0).play();
		assertThat(game.getGrid().getColumn(0).getTokenAtRow(1).isYellow()).isFalse();
		assertThat(game.getGrid().getColumn(0).getTokenAtRow(1).isRed()).isTrue();

		// retest first token didn't change
		assertThat(game.getGrid().getColumn(0).getTokenAtRow(0).isYellow()).isTrue();
		assertThat(game.getGrid().getColumn(0).getTokenAtRow(0).isRed()).isFalse();
	}

}
