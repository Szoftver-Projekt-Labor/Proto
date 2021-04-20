package com.panzerkampfwagen.controllers;

import com.panzerkampfwagen.units.Unit;

/**
 * Absztrakt, egy egységet irányít.
 */
public abstract class Controller {
	static final int defaultStepsPerTurn = 1;
	protected final int stepsPerTurn;
	protected int steps;
	protected Unit unit;

	/**
	 * Paraméter nélküli konstruktor Beállítja a stepsPerTurn-t az
	 * alapértelmezettre.
	 */
	public Controller() {
		this.stepsPerTurn = defaultStepsPerTurn;
	}

	/**
	 * Controller konstruktor. Beállítja a stepsPerTurn-t a paraméterre.
	 * 
	 * @param stepsPerTurn this.stepsPerTurn = stepsPerTurn
	 */
	public Controller(int stepsPerTurn) {
		this.stepsPerTurn = stepsPerTurn;
	}

	/**
	 * Beállítja az irányítandó egységet.
	 * 
	 * @param unit Az irányítandó egység.
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	/**
	 * Step értékét beállítja a stepsPerTurn-re. Kiadja a unitnak a parancsokat.
	 */
	public void takeTurn() {
		this.steps = stepsPerTurn;
		// Get input and call possible moves on unit in child @Override-s
	}

	/**
	 * Jelzi a Controllernek, hogy halott az egyég. Unit.die() hívja meg.
	 */
	public void unitDied() {
		System.out.println(this.unit + " died");
		this.unit = null;
	}

	/**
	 * Csökkenti a step értékét eggyel.
	 */
	public void step() {
		--this.steps;
	}
}
