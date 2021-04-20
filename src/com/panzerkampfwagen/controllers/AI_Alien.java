package com.panzerkampfwagen.controllers;

import com.panzerkampfwagen.Asteroid;
import com.panzerkampfwagen.units.UFO;

public class AI_Alien extends Controller {
	@Override
	public void takeTurn() {
		super.takeTurn();

		Asteroid a = unit.getAsteroid();

		if (a != null) {
			((UFO) unit).mine();
			if (this.steps == 0)
				return;
		}
		unit.move(unit.getReceiver().getRandomNeighbour());
	}
}
