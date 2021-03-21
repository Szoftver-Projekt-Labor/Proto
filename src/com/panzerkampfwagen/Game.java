package com.panzerkampfwagen;

public class Game {
	private static Level level = new Level();
	private static boolean gameInProgress = false;

	public static Level getLevel() {
		System.out.println("getLevel");		
		return level;
	}

	public void play() {
		System.out.println("play");	
		gameInProgress = true;
		while (gameInProgress) {
			level.tickThings();
		}
	}

	public static void victory() {
		System.out.println("victory");
		gameInProgress = false;
		// TODO: level kinullázása, hogy ne hívogassa a többi tick-et
		System.out.println("Győztél. Yaay.");
	}

	public static void defeat() {
		System.out.println("defeat");
		gameInProgress = false;
		System.out.println("You died.");
	}
}
