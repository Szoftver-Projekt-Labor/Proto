package com.panzerkampfwagen;

public class Game {
	private static Level level;
	private static boolean gameInProgress = false;

	public static Level getLevel() {
		return level;
	}

	public void play() {
		gameInProgress = true;
		while (gameInProgress) {
			level.tickThings();
		}
	}

	public static void victory() {
		gameInProgress = false;
		// TODO: level kinullázása, hogy ne hívogassa a többi tick-et
		System.out.println("Győztél. Yaay.");
	}

	public static void defeat() {
		gameInProgress = false;
		System.out.println("You died.");
	}
}
