package com.panzerkampfwagen.mining;

import com.panzerkampfwagen.receivers.Asteroid;
import com.panzerkampfwagen.units.Settler;
import com.panzerkampfwagen.utility.InCore;

public class MaterialOre implements InCore {
	private CoreMaterial content;

	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		return content.insertToCoreOf(coreOwner);
	}

	@Override
	public boolean extract(Settler miner) {
		boolean res = content.onMined(miner);
		if (res) {
			miner.getAsteroid().ejectCore();
		}
		return res;
	}
}
