package fr.em_ilien.connect4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GridTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void placeTwoTokens() {
		Game game = new Game();
		game.getGrid().getColumn(3).play();
		game.getGrid().getColumn(3).play();
		assertThat(game.getGrid().getColumn(3).isTokenPlayed(0)).isTrue();
		assertThat(game.getGrid().getColumn(3).isTokenPlayed(1)).isTrue();
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
}
