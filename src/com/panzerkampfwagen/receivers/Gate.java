package com.panzerkampfwagen.receivers;

import com.panzerkampfwagen.Game;
import com.panzerkampfwagen.itemization.BuildableItem;
import com.panzerkampfwagen.itemization.Item;
import com.panzerkampfwagen.units.Settler;
import com.panzerkampfwagen.units.Unit;

public class Gate extends Receiver implements BuildableItem {
	protected Gate pair;
	private boolean isOn = false;
	private boolean isPlaced = false;

	@Override
	public void addUnit(Unit unit) {
		if (this.isOn) {
			unit.setReceiver(this.pair);
			return;
		}
		unit.setReceiver(this);
	}

	// #region Item & BuildableItem implementations

	@Override
	public boolean sameAs(Item other) {
		return other instanceof Gate;
	}

	@Override
	public boolean dropItem(Settler dropper) {
		Game.getLevel().addThing(this);
		this.isPlaced = true;
		if (this.pair.isPlaced) {
			this.isOn = true;
			this.pair.isOn = true;
		}
		this.tick();
		return true;
	}

	@Override
	public BuildableItem[] make() {
		Gate[] pairOfGates = new Gate[2];
		pairOfGates[0] = new Gate();
		pairOfGates[1] = new Gate();

		pairOfGates[0].pair = pairOfGates[1];
		pairOfGates[1].pair = pairOfGates[0];

		return pairOfGates;
	}

	// #endregion Item & BuildableItem implementations
}
