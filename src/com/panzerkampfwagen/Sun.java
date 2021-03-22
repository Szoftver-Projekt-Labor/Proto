package com.panzerkampfwagen;

import java.util.Random;

public class Sun {
	private int timeTillStorm;

	public Sun() {
		System.out.println("Sun.Sun");
		this.setRandomTime();
	}

	public int getTimeTillStorm() {
		System.out.println("Sun.getTimeTillStorm");
		return timeTillStorm;
	}

	// TODO: Remove from prod
	public void setTimeTillStorm(int rounds) {
		System.out.println("Sun.setTimeTillStorm");
		this.timeTillStorm = rounds;
	}

	public void tick() {
		System.out.println("Sun.tick");
		--this.timeTillStorm;
		if (timeTillStorm < 2) {
			System.out.println("! " + timeTillStorm + " kör van napviharig");
		}
		if (timeTillStorm == 0) {
			Game.getLevel().solarStormTime();
			this.setRandomTime();
			return;
		}
	}

	private void setRandomTime() {
		System.out.println("Sun.setRandomTime");
		// 10 - 20 kör
		Random random = new Random();
		this.timeTillStorm = random.nextInt(11) + 10;
	}
}
