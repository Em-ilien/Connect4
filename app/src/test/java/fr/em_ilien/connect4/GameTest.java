package fr.em_ilien.connect4;

import static org.assertj.core.api.Assertions.assertThat;

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
