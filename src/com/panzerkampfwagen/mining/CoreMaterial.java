package com.panzerkampfwagen.mining;

import com.panzerkampfwagen.itemization.Item;
import com.panzerkampfwagen.receivers.Asteroid;
import com.panzerkampfwagen.units.Settler;
import com.panzerkampfwagen.utility.InCore;

public abstract class CoreMaterial implements InCore, Item {
	protected Asteroid asteroid;

	public boolean onMined(Settler miner) {
		return this.extract(miner);
	}

	@Override
	public boolean extract(Settler miner) {
		if (!miner.loadCargo(this))
			return false;
		this.asteroid.ejectCore();
		this.asteroid = null;
		return true;
	}

	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		if (!coreOwner.insertCore(this))
			return false;
		this.asteroid = coreOwner;
		return true;
	}

	@Override
	public boolean dropItem(Settler dropper) {
		return insertToCoreOf(dropper.getAsteroid());
	}

	public void tick() {
	}
}
