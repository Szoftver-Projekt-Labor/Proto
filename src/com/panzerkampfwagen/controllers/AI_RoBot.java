package com.panzerkampfwagen.controllers;

import com.panzerkampfwagen.Asteroid;
import com.panzerkampfwagen.units.Robot;

public class AI_RoBot extends Controller {
	protected Robot unit;

	/**
	 * Beállítja az irányítandó egységet.
	 * 
	 * @param ufo Az irányítandó egység.
	 */
	public void setUnit(Robot robot) {
		super.setUnit(robot);
		this.unit = robot;
	}

	@Override
	public void takeTurn() {
		super.takeTurn();

		Asteroid a = unit.getAsteroid();

		if(a != null){
			((Robot)unit).drill();			
			if(this.steps == 0) return;
		}
		unit.move(unit.getReceiver().getRandomNeighbour());
	}
}
}
