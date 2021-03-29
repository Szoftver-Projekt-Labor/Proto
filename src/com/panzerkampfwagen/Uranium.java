package com.panzerkampfwagen;

public class Uranium extends CoreMaterial {
	@Override
	public boolean onMined(Miner miner) {
		if (this.asteroid.isCloseToSun())
			asteroid.destroy();
		return super.onMined(miner);
	}

	@Override
	public boolean sameAs(Item other) {
		return other instanceof Uranium;
	}
}
