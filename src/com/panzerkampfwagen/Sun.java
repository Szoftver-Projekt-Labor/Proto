package com.panzerkampfwagen;

import java.util.Random;

public class Sun {
	private int timeTilStorm;
	private final int from, diff;

	/**
	 * 
	 * @param from Min. number of turns until solar storm
	 * @param to   Max. number of turns until solar storm
	 */
	public Sun(int from, int to) {
		if (from > to)
			throw new IllegalArgumentException("Lower bound is higher than the upper bound");
		this.from = from;
		this.diff = to - from + 1;
		this.setRandomTime();
	}

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

	private void setRandomTime() {
		Random random = new Random();
		this.timeTilStorm = random.nextInt(diff) + from;
	}
}
