package com.panzerkampfwagen;

public abstract class CoreMaterial implements InCore, Item {
	protected Asteroid asteroid;

	public void setAsteroid(Asteroid asteroid) {
		this.asteroid = asteroid;
	}

	/**
	 * Should remove Ticking descendants from Level
	 */
	protected void ejectThis() {
		this.asteroid.ejectCore();
		this.asteroid = null;
	}

	@Override
	public boolean extract(Miner miner) {
		if (!miner.loadCargo(this))
			return false;
		this.ejectThis();
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
	public boolean dropItem(Unit dropper) {
		Asteroid a = dropper.getAsteroid();
		if (a != null)
			return false;
		return insertToCoreOf(a);
	}
}
