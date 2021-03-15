package com.panzerkampfwagen.environment;

import java.util.Random;

import com.panzerkampfwagen.Game;

public class Sun {
	private int timeTillStorm;
	private Random random = new Random();

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
		this.timeTillStorm = random.nextInt(11) + 10;
	}
}
