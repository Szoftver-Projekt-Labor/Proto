package com.panzerkampfwagen.resources;

import com.panzerkampfwagen.Item;
import com.panzerkampfwagen.units.Miner;

/**
 * Uránt reprezentál, nyersanyag.
 */
public class Uranium extends CoreMaterial {
	int remainingExposures = 3;

	/**
	 * Kibányássza a nyersanyagot.
	 * 
	 * @param miner aki bányássza ki
	 * @return sikerült e (true ha igen)
	 */
	@Override
	public boolean extract(Miner miner) {
		if (this.asteroid.isCloseToSun() && --remainingExposures < 1) {
			this.asteroid.destroy();
		}
		return super.extract(miner);
	}

	/**
	 * Megvizsgálja, hogy az adott item amivel összehasonlítjuk, az urán-e.
	 * 
	 * @param other a hasonlítandó item
	 * @return ugyanolyan e (true ha igen)
	 */
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Uranium;
	}

	@Override
	public String status() {
		return super.status() + "\n\tremainingExposures: " + remainingExposures;
	}
}
