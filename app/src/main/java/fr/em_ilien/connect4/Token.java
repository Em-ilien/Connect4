package fr.em_ilien.connect4;

public class Token {
	private Color color;

	public Token(Color color) {
		this.color = color;
	}

	public boolean isYellow() {
		return color == Color.YELLOW;
	}

	public boolean isRed() {
		return color == Color.RED;
	}

	public Color getColor() {
		return color;
	}
}
