package com.panzerkampfwagen;

/**
 * Absztrakt, egy egységet irányít.
 */
public abstract class Controller {
	protected Unit unit;
	protected int steps;
	protected final int stepsPerTurn = 1;

	/**
	 * A Controller konstruktora Beállítja a unitot.
	 * 
	 * @param unit az irányítandó egység
	 */
	public Controller(Unit unit) {
		unit.setController(this);
		this.unit = unit;
	}

	/**
	 * Step értékét beállítja a stepPerTurn-re. Kiadja a unitnak a parancsokat.
	 */
	public void takeTurn() {
		this.steps = stepsPerTurn;
		// Get input and call possible moves on unit in child @Override-s
	}

	/**
	 * Jelzi a Controllernek, hogy halott az egyég. Unit.die() hívja meg.
	 */
	public void unitDied() {
		this.unit = null;
		System.out.println("You died");
	}

	/**
	 * Csökkenti a step értékét eggyel.
	 */
	public void step() {
		--this.steps;
	}
}
