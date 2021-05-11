package com.panzerkampfwagen;

import com.panzerkampfwagen.units.Unit;

/**
 * Interface, egy itemet reprezentál.
 */
public interface Item extends Thing {

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
