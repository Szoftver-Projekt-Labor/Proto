package com.panzerkampfwagen.controllers;

import com.panzerkampfwagen.Asteroid;
import com.panzerkampfwagen.units.UFO;

public class AI_Alien extends Controller {
	protected UFO unit;

	/**
	 * Beállítja az irányítandó egységet.
	 * 
	 * @param ufo Az irányítandó egység.
	 */
	public void setUnit(UFO ufo) {
		super.setUnit(ufo);
	}

	@Override
	public void takeTurn() {
		super.takeTurn();

		Asteroid a = unit.getAsteroid();

		if(a != null){
			((UFO)unit).mine();			
			if(this.steps == 0) return;
		}
		unit.move(unit.getReceiver().getRandomNeighbour());
	}
}
