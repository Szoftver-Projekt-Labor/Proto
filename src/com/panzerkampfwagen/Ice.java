package com.panzerkampfwagen;

public class Ice extends CoreMaterial implements Tickable {

	@Override
	public void tick() {
		if (this.asteroid.getLayerCount() == 0 && this.asteroid.isCloseToSun()) {
			this.ejectThis();
			Level.unsubscribeTick(this);
		}
	}

	@Override
	public boolean extract(Miner miner) {
		if (!super.extract(miner))
			return false;
		Level.unsubscribeTick(this);
		return true;
	}

	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		if (!super.insertToCoreOf(coreOwner))
			return false;
		Level.subscribeTick(this);
		return true;
	}

	@Override
	public boolean sameAs(Item other) {
		return other instanceof Ice;
	}
}
