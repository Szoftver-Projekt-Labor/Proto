package com.panzerkampfwagen;

/**
 * Interface, körönként lehetőséget ad a leszármazott léptetésére.
 */
public interface Tickable {
	/**
 	* A felelősség megvalósításáért felel, ezt implementálja a többi osztály
 	*/
	public void tick();
}
