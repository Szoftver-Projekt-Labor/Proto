package com.panzerkampfwagen;

import java.util.Random;

public class Sun {
	private int timeTillStorm;
	private final int from, diff;

	public Sun(int from, int to) {
		if (from > to)
			throw new IllegalArgumentException("Lower bound is higher than the upper bound");
		this.from = from;
		this.diff = to - from + 1;
		this.setRandomTime();
	}

	public void tick() {
		--this.timeTillStorm;
		if (timeTillStorm < 2) {
			System.out.println("! " + timeTillStorm + " kör van napviharig");
		}
		if (timeTillStorm <= 0) {
			Level.solarStormTime();
			this.setRandomTime();
			return;
		}
	}

	private void setRandomTime() {
		Random random = new Random();
		this.timeTillStorm = random.nextInt(diff) + from;
	}
}
