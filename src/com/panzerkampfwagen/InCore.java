package com.panzerkampfwagen;

/**
* Interface, a magba kerülhető dolgokat reprezentálja.
*/
public interface InCore {
	
	/**
	* A felelősség megvalósításáért felel, ezt implementálja a többi osztály
	* @param miner az a Miner, aki kiszedi a magot
	* @return igaz, ha sikerült
	*/
	public boolean extract(Miner miner);


	/**
	* a felelősség megvalósításáért felel, ezt implementálja a többi osztály
	* @param coreOwner az új tulajdonos
	* @return igaz, ha sikerült
	*/
	public boolean insertToCoreOf(Asteroid coreOwner);
}
