package com.panzerkampfwagen;

import java.util.Random;

public class Sun {
	private int timeTillStorm;

	public Sun() {
		this.setRandomTime();
	}

	public void tick() {
		if (timeTillStorm < 2) {
			System.out.println("! " + timeTillStorm + " kör van napviharig");
		}

		if (timeTillStorm == 0) {
			Game.getLevel().solarStormTime();
			this.setRandomTime();
			return;
		}

		--this.timeTillStorm;
	}

	private void setRandomTime() {
		// 10 - 20 kör
		Random random = new Random();
		this.timeTillStorm = random.nextInt(11) + 10;
	}
}
