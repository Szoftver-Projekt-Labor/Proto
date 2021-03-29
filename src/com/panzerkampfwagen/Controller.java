package com.panzerkampfwagen;

import java.lang.ref.WeakReference;

public abstract class Controller {
	protected WeakReference<Unit> unit;
	protected int steps;
	protected final int stepsPerTurn = 1;

	public Controller(Unit unit) {
		this.unit = new WeakReference<>(unit);
	}

	public void takeTurn() {
		this.steps = stepsPerTurn;
		// Get input and call possible moves on unit
	}

	public void step() {
		--this.steps;
	}
}
