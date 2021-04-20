package com.panzerkampfwagen;

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
}
