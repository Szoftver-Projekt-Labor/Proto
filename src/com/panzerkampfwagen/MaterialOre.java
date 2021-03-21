package com.panzerkampfwagen;

public class MaterialOre implements InCore {
	private CoreMaterial content;

	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		System.out.println("MaterialCore.insertToCoreOf");
		return content.insertToCoreOf(coreOwner);
	}

	@Override
	public boolean extract(Settler miner) {
		System.out.println("MaterialCore.extract");
		boolean res = content.onMined(miner);
		if (res) {
			miner.getAsteroid().ejectCore();
		}
		return res;
	}
}
