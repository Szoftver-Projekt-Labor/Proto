package com.panzerkampfwagen;

import com.panzerkampfwagen.units.Miner;

/**
 * Interface, a magba kerülhető dolgokat reprezentálja.
 */
public interface InCore {
	/**
	 * Jellemzően az implementáló osztályok egy adattagját állítaná be
	 * 
	 * @param asteroid Az aszteroida amin az InCore van
	 */
	public void setAsteroid(Asteroid asteroid);

	/**
	 * A felelősség megvalósításáért felel, ezt implementálja a többi osztály
	 * 
	 * @param miner az a Miner, aki kiszedi a magot
	 * @return igaz, ha sikerült
	 */
	public boolean extract(Miner miner);

	/**
	 * a felelősség megvalósításáért felel, ezt implementálja a többi osztály
	 * 
	 * @param coreOwner az új tulajdonos
	 * @return igaz, ha sikerült
	 */
	public boolean insertToCoreOf(Asteroid coreOwner);
}
