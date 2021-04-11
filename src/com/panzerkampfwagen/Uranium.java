package com.panzerkampfwagen;

public class Uranium extends CoreMaterial {
	int remainingExposures = 3;

	@Override
	public boolean extract(Miner miner) {
		if (this.asteroid.isCloseToSun() && --remainingExposures < 1) {
			this.asteroid.destroy();
		}
		return super.extract(miner);
	}

	@Override
	public boolean sameAs(Item other) {
		return other instanceof Uranium;
	}
}
