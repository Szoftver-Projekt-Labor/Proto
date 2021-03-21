package com.panzerkampfwagen;

public class Uranium extends CoreMaterial {

	@Override
	public boolean onMined(Settler miner) {
		System.out.println("Uranium.onMined");
		if (this.asteroid.isCloseToSun())
			asteroid.destroy();
		return super.onMined(miner);
	}

	@Override
	public boolean sameAs(Item other) {
		System.out.println("Uranium.sameAs");
		return other instanceof Uranium;
	}
}
