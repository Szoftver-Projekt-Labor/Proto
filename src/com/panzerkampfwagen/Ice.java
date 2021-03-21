package com.panzerkampfwagen;

public class Ice extends CoreMaterial {

	@Override
	public void tick() {
		System.out.println("Ice.tick");
		if (this.asteroid.getLayerCount() == 0 && this.asteroid.isCloseToSun()) {
			this.asteroid.ejectCore();
			this.asteroid = null;
			Game.getLevel().removeThing(this);
		}
	}

	@Override
	public boolean extract(Settler miner) {
		System.out.println("Ice.extract");
		if (!super.extract(miner))
			return false;
		Game.getLevel().removeThing(this);
		return true;
	}

	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		System.out.println("Ice.insertToCoreOf");
		if (!super.insertToCoreOf(coreOwner))
			return false;
		Game.getLevel().addThing(this);
		return true;
	}

	@Override
	public boolean sameAs(Item other) {
		System.out.println("Ice.sameAs");
		return other instanceof Ice;
	}
}
