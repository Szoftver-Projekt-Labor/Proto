package com.panzerkampfwagen;

import java.lang.ref.WeakReference;

public class Gate extends Receiver implements BuildableItem {
	protected WeakReference<Gate> pair;
	private boolean on = false;
	private boolean placed = false;

	public Gate getPair() {
		System.out.println("Gate.getPair");
		return this.pair.get();
	}

	@Override
	public void addUnit(Unit unit) {
		System.out.println("Gate.addUnit");
		if (this.on) {
			unit.setReceiver(this.pair.get());
			return;
		}
		unit.setReceiver(this);
	}

	@Override
	public void removeUnit(Unit unit) {
		System.out.println("Gate.removeUnit");
	}

	// #region Item & BuildableItem implementations

	@Override
	public boolean sameAs(Item other) {
		System.out.println("Gate.sameAs");
		return other instanceof Gate;
	}

	@Override
	public boolean dropItem(Settler dropper) {
		System.out.println("Gate.dropItem");
		Game.getLevel().addThing(this);
		this.placed = true;
		if (this.pair.get().placed) {
			this.on = true;
			this.pair.get().on = true;
		}
		this.tick();
		return true;
	}

	@Override
	public BuildableItem[] make() {
		System.out.println("Gate.make");
		Gate[] pairOfGates = new Gate[2];
		pairOfGates[0] = new Gate();
		pairOfGates[1] = new Gate();

		pairOfGates[0].pair = new WeakReference<Gate>(pairOfGates[1]);
		pairOfGates[1].pair = new WeakReference<Gate>(pairOfGates[0]);

		return pairOfGates;
	}

	@Override
	public Item[] getBill() {
		return new Item[] { new Iron(), new Iron(), new Ice(), new Uranium() };
	}

	// #endregion Item & BuildableItem implementations
}
