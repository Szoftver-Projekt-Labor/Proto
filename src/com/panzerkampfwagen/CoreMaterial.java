package com.panzerkampfwagen;

public abstract class CoreMaterial implements InCore, Item {
	protected Asteroid asteroid;

	public boolean onMined(Settler miner) {
		System.out.println("CoreMaterial.onMined");
		return this.extract(miner);
	}

	/**
	 * Should remove Ticking descendants from Level
	 */
	@Override
	public boolean extract(Settler miner) {
		System.out.println("CoreMaterial.extract");
		if (!miner.loadCargo(this))
			return false;
		this.asteroid.ejectCore();
		this.asteroid = null;
		return true;
	}

	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {		
		System.out.println("CoreMaterial.insertToCoreOf");
		if (!coreOwner.insertCore(this))
			return false;
		this.asteroid = coreOwner;
		return true;
	}

	@Override
	public boolean dropItem(Settler dropper) {
		System.out.println("CoreMaterial.dropItem");
		return insertToCoreOf(dropper.getAsteroid());
	}

	public void tick() {		
		System.out.println("CoreMaterial.tick");
	}
}
