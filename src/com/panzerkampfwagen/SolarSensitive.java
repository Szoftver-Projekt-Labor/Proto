package com.panzerkampfwagen;

/**
 * Interface, Solar storm esetén történik valami az ért objektummal.
 */
public interface SolarSensitive {
	/**
	 * A felelősség megvalósításáért felel, ezt implementálja a többi osztály
	 */
	public void onSolarStorm();
}
