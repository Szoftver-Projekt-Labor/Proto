package com.panzerkampfwagen;

/**
 * Interface, egy itemet reprezentál.
 */
public interface Item {

	/**
	 * A felelősség megvalósításáért felel, ezt implementálja a többi osztály.
	 * 
	 * @param other az az item, amivel összehasonlítjuk
	 * @return igaz, ha egyezik
	 */
	public boolean sameAs(Item other);

	/**
	 * A felelősség megvalósításáért felel, ezt implementálja a többi osztály.
	 * 
	 * @param dropper az a unit, amelyik ledobja
	 * @return igaz, ha sikerült
	 */
	public boolean dropItem(Unit dropper);
}
