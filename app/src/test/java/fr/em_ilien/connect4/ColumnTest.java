package fr.em_ilien.connect4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ColumnTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void placeAToken() {
		Game game = new Game();
		game.getGrid().getColumn(3).play();
		assertThat(game.getGrid().getColumn(3).isTokenPlayed(0)).isTrue();
		assertThat(game.getGrid().getColumn(3).isTokenPlayed(1)).isFalse();
		assertThat(game.getGrid().getColumn(0).isTokenPlayed(0)).isFalse();
	}

}
