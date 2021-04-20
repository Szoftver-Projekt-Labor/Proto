package com.panzerkampfwagen.resources;

import com.panzerkampfwagen.Asteroid;
import com.panzerkampfwagen.Item;
import com.panzerkampfwagen.Level;
import com.panzerkampfwagen.Tickable;
import com.panzerkampfwagen.units.Miner;

/**
 * Jégvizet reprezentál, nyersanyagfajta.
 */
public class Ice extends CoreMaterial implements Tickable {

	/**
	 * Ha napközelben van és nincs köpeny, akkor eltűnik.
	 */
	@Override
	public void tick() {
		if (this.asteroid.getLayerCount() == 0 && this.asteroid.isCloseToSun()) {
			this.ejectThis();
			Level.unsubscribeTick(this);
		}
	}

	/**
	 * Kibányássza a nyersanyagot a miner.
	 * 
	 * @param miner az a Miner, aki kibányássza
	 * @return igaz, ha sikerült
	 */
	@Override
	public boolean extract(Miner miner) {
		if (!super.extract(miner))
			return false;
		Level.unsubscribeTick(this);
		return true;
	}

	/**
	 * Beállít egy új aszteroidát tulajdonosként.
	 * 
	 * @param coreOwner az új tulajdonos
	 * @return igaz, ha sikerült
	 */
	@Override
	public boolean insertToCoreOf(Asteroid coreOwner) {
		if (!super.insertToCoreOf(coreOwner))
			return false;
		Level.subscribeTick(this);
		return true;
	}

	/**
	 * Megnézi, hogy az other Ice típusú-e.
	 * 
	 * @param other amivel összehasonlítjuk
	 * @return igaz, ha egyezik
	 */
	@Override
	public boolean sameAs(Item other) {
		return other instanceof Ice;
	}
}
