package fr.em_ilien.connect4;

public enum Color {
	YELLOW, RED;

	public Color getOther() {
		return this != YELLOW ? YELLOW : RED;		
	}
}
