package com.panzerkampfwagen.mining;

import com.panzerkampfwagen.itemization.Item;
import com.panzerkampfwagen.receivers.Asteroid;
import com.panzerkampfwagen.units.Settler;

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
