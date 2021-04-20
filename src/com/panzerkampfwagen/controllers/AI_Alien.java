package com.panzerkampfwagen.controllers;

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
		this.unit = ufo;
	}
}
