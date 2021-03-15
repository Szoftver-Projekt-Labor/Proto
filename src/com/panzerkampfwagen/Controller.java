package com.panzerkampfwagen;

public abstract class Controller {
	protected Unit unit;
	protected int steps;
	protected final int stepsPerTurn = 1;

	public Controller(Unit unit) {
		this.unit = unit;
	}

	public void takeTurn() {
		this.steps = stepsPerTurn;
		// Get input and call possible moves on unit
	}

	public void step() {
		--this.steps;
	}

	public void unitDied() {
		this.unit = null;
	}
}
