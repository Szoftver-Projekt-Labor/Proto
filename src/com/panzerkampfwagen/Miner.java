package com.panzerkampfwagen;

public abstract class Miner extends Unit {
	public abstract boolean loadCargo(Item item);

	public void mine() {
		Asteroid a = this.getAsteroid();
		if (a != null && a.getCore() != null && a.extractCore(this)) {
			// controller.step();
		}
	}
}
