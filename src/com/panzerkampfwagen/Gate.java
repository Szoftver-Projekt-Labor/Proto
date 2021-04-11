package com.panzerkampfwagen;

import java.lang.ref.WeakReference;

public class Gate extends Receiver implements BuildableItem, AllEventCompatible {
	protected WeakReference<Gate> pair;
	private boolean on = false;
	private boolean placed = false;
	private boolean damaged = false;

	public Gate getPair() {
		return this.pair.get();
	}

	/**
	 * Anchors this to a random neighboring asteroid
	 */
	private void changeAnchor() {
		Asteroid anchor = (Asteroid) this.neighbours.get(0);
		this.neighbours.remove(0);
		this.neighbours.add(anchor.getRandomNeighbour());
	}

	@Override
	public boolean addUnit(Unit unit) {
		if (this.on) {
			unit.setReceiver(this.pair.get());
			return true;
		}
		return false;
	}

	@Override
	public void removeNeighbour(Receiver receiver) {
		this.changeAnchor();
	}

	// #region Event handlers

	@Override
	public void tick() {
		if (!this.damaged)
			return;
		this.changeAnchor();
	}

	@Override
	public void onSolarStorm() {
		this.damaged = true;
	}

	// #endregion

	// #region Item & BuildableItem implementations

	@Override
	public boolean sameAs(Item other) {
		return other instanceof Gate;
	}

	@Override
	public boolean dropItem(Unit dropper) {
		Level.subscribeAll(this);
		this.placed = true;
		Gate pair = this.pair.get();
		if (pair.placed) {
			this.on = true;
			pair.on = true;
		}
		this.tick();

		Asteroid anchor = dropper.getAsteroid();
		if (anchor == null)
			return false;
		this.addNeighbour(anchor);
		anchor.addNeighbour(this);
		return true;
	}

	@Override
	public BuildableItem[] make() {
		Gate[] pairOfGates = new Gate[2];
		pairOfGates[0] = new Gate();
		pairOfGates[1] = new Gate();

		pairOfGates[0].pair = new WeakReference<Gate>(pairOfGates[1]);
		pairOfGates[1].pair = new WeakReference<Gate>(pairOfGates[0]);

		return pairOfGates;
	}

	@Override
	public Item[] getBuildCost() {
		return new Item[] { new Iron(), new Iron(), new Ice(), new Uranium() };
	}

	// #endregion
}
