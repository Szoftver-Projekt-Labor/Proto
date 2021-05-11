package com.panzerkampfwagen;

import com.panzerkampfwagen.units.Settler;

/**
 * Inteface, az építhető tárgyak megvalósításáért felel.
 */
public interface BuildableItem extends Item {
	public Item[] getBuildCost();

	public boolean onMake(Settler creator);
}
