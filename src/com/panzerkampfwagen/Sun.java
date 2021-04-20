package com.panzerkampfwagen;

import java.util.Random;

/**
 * Napot reprezentálja, napvihart és napközelséget idézhet elő.
 */
public class Sun implements Tickable {
	private int timeTilStorm;
	private final int from, diff;

	/**
	 * Beállítja a minimum és a maximum körszámot, ami a napviharig hátravan.
	 * 
	 * @param from Minimum körszám ami a napviharig hátravan.
	 * @param to   Maximum körszám ami a napviharig hátravan.
	 */
	public Sun(int from, int to) {
		if (from > to)
			throw new IllegalArgumentException("Lower bound is higher than the upper bound");
		this.from = from;
		this.diff = to - from + 1;
		this.setRandomTime();
	}

	/**
	 * Csökkenti a timeTilStorm értékét, ha 2-nél kisebb, kiírja, hogy ennyi kör van
	 * hátra. 0-nál bekövetkezik a napvihar.
	 */
	public void tick() {
		--this.timeTilStorm;
		if (timeTilStorm < 2) {
			System.out.println("! " + timeTilStorm + " kör van napviharig");
		}
		if (timeTilStorm <= 0) {
			Level.solarStormTime();
			this.setRandomTime();
			return;
		}
	}

	/**
	 * Beállítja a timeTilStorm értékét egy véletlen számra.
	 */
	private void setRandomTime() {
		Random random = new Random();
		this.timeTilStorm = random.nextInt(diff) + from;
	}

	@Override
	public String status() {
		return this + ":\n\ttimeTilStorm: " + timeTilStorm + "\n\t from-to: [" + from + "," + from + (diff - 1) + "]";
	}
}
