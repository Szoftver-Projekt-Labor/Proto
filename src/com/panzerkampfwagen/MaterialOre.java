package com.panzerkampfwagen;

public class MaterialOre implements InCore {
	private CoreMaterial content;

	public MaterialOre(CoreMaterial content) {
		this.content = content;
	}

	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		if (!coreOwner.insertCore(this))
			return false;
		content.setAsteroid(coreOwner);
		return true;
	}

	@Override
	public boolean extract(Miner miner) {
		boolean res = content.onMined(miner);
		if (res) {
			miner.getAsteroid().ejectCore();
		}
		return res;
	}
}
