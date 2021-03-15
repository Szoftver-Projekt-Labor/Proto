package com.panzerkampfwagen;

public class Ice extends CoreMaterial {

	@Override
	public void tick() {
		if (this.asteroid.isCloseToSun()) {
			this.asteroid.ejectCore();
			this.asteroid = null;
			Game.getLevel().removeThing(this);
		}
	}

	@Override
	public boolean extract(Settler miner) {
		if (!super.extract(miner))
			return false;
		Game.getLevel().removeThing(this);
		return true;
	}

	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		if (!super.insertToCoreOf(coreOwner))
			return false;
		Game.getLevel().addThing(this);
		return true;
	}

	@Override
	public boolean sameAs(Item other) {
		return other instanceof Ice;
	}
}
