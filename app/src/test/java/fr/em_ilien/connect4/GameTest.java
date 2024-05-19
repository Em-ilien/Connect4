package fr.em_ilien.connect4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
		game.play(3);
		assertThat(game.isTokenPlayed(3, 0)).isTrue();
		assertThat(game.isTokenPlayed(3, 1)).isFalse();
		assertThat(game.isTokenPlayed(0, 0)).isFalse();
	}

	@Test
	void placeTwoTokens() {
		Game game = new Game();
		game.play(3);
		game.play(3);
		assertThat(game.isTokenPlayed(3, 0)).isTrue();
		assertThat(game.isTokenPlayed(3, 1)).isTrue();
	}

	@Test
	void placeSevenTokens() {
		Game game = new Game();
		game.play(3);
		game.play(3);
		game.play(3);
		game.play(3);
		game.play(3);
		game.play(3);
		assertThrowsExactly(IllegalStateException.class, () -> game.play(3));
	}

	@Test
	void placeTokenInInexistingColumns() {
		Game game = new Game();
		assertThrowsExactly(IndexOutOfBoundsException.class, () -> game.play(-1));
		assertThrowsExactly(IndexOutOfBoundsException.class, () -> game.play(7));
	}

}
