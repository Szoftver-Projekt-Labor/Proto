package com.panzerkampfwagen;

public class Uranium extends CoreMaterial {

	@Override
	public boolean onMined(Settler miner) {
		Asteroid a = miner.getAsteroid();
		if (a.isCloseToSun())
			a.destroy();

		return super.onMined(miner);
	}

	@Override
	public boolean sameAs(Item other) {
		return other instanceof Uranium;
	}
}
