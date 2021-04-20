package com.panzerkampfwagen;

import com.panzerkampfwagen.units.Miner;
import com.panzerkampfwagen.units.Unit;

/**
 * Absztrakt, a magban lévő nyersanyagot reprezentálja.
 */
public abstract class CoreMaterial implements InCore, Item {
	protected Asteroid asteroid;

	/**
	 * Beállítja az aszteroida értékét.
	 * 
	 * @param asteroid a nyersanyagot tartalmazó aszteroida
	 */
	public void setAsteroid(Asteroid asteroid) {
		this.asteroid = asteroid;
	}

	/**
	 * Should remove Ticking descendants from Level
	 */
	protected void ejectThis() {
		this.asteroid.ejectCore();
		this.asteroid = null;
	}

	/**
	 * Kiszedi a magot, ha tudja.
	 * 
	 * @param miner a mag kiszedésével próbálkozó telepes
	 * @return művelet sikeressége
	 */
	@Override
	public boolean extract(Miner miner) {
		if (!miner.loadCargo(this))
			return false;
		this.ejectThis();
		return true;
	}

	/**
	 * Beállít egy új aszteroidát tulajdonosként.
	 * 
	 * @param coreOwner a mag tulajdonosa
	 * @return művelet sikeressége
	 */
	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		if (!coreOwner.insertCore(this))
			return false;
		this.asteroid = coreOwner;
		return true;
	}

	/**
	 * Visszahelyezi a magba a nyersanyagot.
	 * 
	 * @param dropper a nyersanyagot eldobó egység
	 * @return művelet sikeressége
	 */
	@Override
	public boolean dropItem(Unit dropper) {
		Asteroid a = dropper.getAsteroid();
		if (a != null)
			return false;
		return insertToCoreOf(a);
	}
}
