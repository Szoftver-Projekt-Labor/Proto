package com.panzerkampfwagen;

/**
 * Interface, körönként lehetőséget ad a leszármazott léptetésére.
 */
public interface Tickable extends Thing {
	/**
	 * A felelősség megvalósításáért felel, ezt implementálja a többi osztály
	 */
	public void tick();
}
