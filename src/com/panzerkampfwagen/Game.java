package com.panzerkampfwagen;

public class Game {
	private static boolean gameInProgress = false;

	public void play() {
		gameInProgress = true;
		while (gameInProgress) {
			Level.tickThings();
		}
	}

	public static void victory() {
		endGame();
		System.out.println("Győztél. Yaay.");
	}

	public static void defeat() {
		endGame();
		System.out.println("You died.");
	}

	public static void endGame() {
		gameInProgress = false;
		Level.clear();
	}
}
