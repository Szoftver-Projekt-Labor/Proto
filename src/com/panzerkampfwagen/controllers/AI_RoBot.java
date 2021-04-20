package com.panzerkampfwagen.controllers;

import com.panzerkampfwagen.Asteroid;
import com.panzerkampfwagen.units.Robot;

public class AI_RoBot extends Controller {
	@Override
	public void takeTurn() {
		super.takeTurn();

		Asteroid a = unit.getAsteroid();

		if (a != null) {
			((Robot) unit).drill();
			if (this.steps == 0)
				return;
		}
		unit.move(unit.getReceiver().getRandomNeighbour());
	}
}
